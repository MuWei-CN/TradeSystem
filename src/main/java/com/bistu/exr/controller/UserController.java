package com.bistu.exr.controller;

import com.bistu.exr.dao.dataEnum.User.GenderEnum;
import com.bistu.exr.dao.dataEnum.User.UserTypeEnum;
import com.bistu.exr.dao.model.User;
import com.bistu.exr.resultinfo.ResultInfo;
import com.bistu.exr.service.iservice.UserService;
import com.bistu.exr.util.MD5Util;
import com.bistu.exr.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bistu.exr.dao.dataEnum.User.StatusEnum.ACTIVE;
import static com.bistu.exr.dao.dataEnum.User.UserTypeEnum.ADMIN;
import static com.bistu.exr.resultinfo.ReturnCode.*;

@Slf4j
@RestController()
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 用户注册接口
    @PostMapping("/register")
    public ResultInfo<String> register(@RequestParam(required = true)String username,
                                       @RequestParam(required = true)String password,
                                       @RequestParam(required = true,name = "user_type")UserTypeEnum userType,
                                       @RequestParam(required = true)String mobile,
                                       @RequestParam(required = false)String email,
                                       @RequestParam(required = false)GenderEnum gender,
                                       @RequestParam(required = false,name = "real_name")String realName) {
        String encodedPassword = MD5Util.string2MD5(password);

        User regUser = User.builder()
                .username(username)
                .password(encodedPassword)
                .userType(userType)
                .mobile(mobile)
                .email(email)
                .gender(gender)
                .realName(realName).build();

        Long userId = -1L;
        try {
            userId = userService.registerService(regUser);
        } catch (DuplicateKeyException e) {
            if (e.getCause().getMessage().contains("username")) {
                log.error("register failed: username already exists");
                return ResultInfo.fail(USERNAME_ALREADY_EXISTS.getCode(), USERNAME_ALREADY_EXISTS.getMessage());
            } else if (e.getCause().getMessage().contains("mobile")) {
                log.error("register failed: mobile already exists");
                return ResultInfo.fail(MOBILE_ALREADY_EXISTS.getCode(), MOBILE_ALREADY_EXISTS.getMessage());
            } else if (e.getCause().getMessage().contains("email")) {
                log.error("register failed: email already exists");
                return ResultInfo.fail(EMAIL_ALREADY_EXISTS.getCode(), EMAIL_ALREADY_EXISTS.getMessage());
            }
        } catch (Exception e) {
            log.error("register failed: " + e.getMessage());
            return ResultInfo.fail(FAIL.getCode(), FAIL.getMessage());
        }

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("userid", userId);
        data.put("password", password);
        String token = JwtUtil.genToken(data);
        return ResultInfo.success(token);
    }

    // 用户登录接口
    @PostMapping("/login")
    public ResultInfo<String> login(@RequestParam(required = true)String username,
                                     @RequestParam(required = true)String password) {
        User user = User.builder().username(username).password(password).build();
        Long userId = -1L;
        try {
            userId = userService.loginService(user);
            if(userId == -1L)
                return  ResultInfo.fail(INCORRECT_PASSWORD.getCode(), INCORRECT_PASSWORD.getMessage());
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("userid",userId);
            map.put("password",password);
            return ResultInfo.success(JwtUtil.genToken(map));
        }catch (NullPointerException e){
            log.error("login failed: Not find user by username");
            return ResultInfo.fail(USERNAME_NOT_EXISTS.getCode(), USERNAME_NOT_EXISTS.getMessage());
        }catch (Exception e){
            log.error("login failed: " + e.getMessage());
            return ResultInfo.fail(FAIL.getCode(), FAIL.getMessage());
        }
    }

    // 获取所有的待审核用户信息
    @GetMapping("/pendings")
    public ResultInfo<List<User>> pengingUsers(@RequestHeader(name = "Authorization") String token){
        Map<String,Object> claim = JwtUtil.parseToken(token);
        User admin = null;
        try {
            Long id = ((Number)claim.get("userid")).longValue();
            admin = userService.searchUserById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResultInfo.fail(FAIL.getCode(), FAIL.getMessage());
        }
        if (admin == null || !MD5Util.passwordIsTrue(claim.get("password").toString(),admin.getPassword()) || admin.getUserType() != ADMIN || admin.getStatus() != ACTIVE)
            return ResultInfo.fail(PERMISSION_DENIED.getCode(), PERMISSION_DENIED.getMessage());
        try {
            return ResultInfo.success(userService.getAllPendings());
        }catch (Exception e){
            log.error("operation failed: " + e.getMessage());
            return ResultInfo.fail(FAIL.getCode(), FAIL.getMessage());
        }
    }
}
