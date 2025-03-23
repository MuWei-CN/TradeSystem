package com.bistu.exr.controller;

import com.bistu.exr.dao.model.CommonUser;
import com.bistu.exr.resultinfo.ResultInfo;
import com.bistu.exr.resultinfo.ReturnCode;
import com.bistu.exr.service.impl.CommonUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 示例文件
 */

// Controller注解，标识这是一个Controller类, 用于处理http请求
@Slf4j
@RestController
public class test {
    // Autowired注解，自动装配，将CommonUserServiceImpl类的实例注入到这里
    @Autowired
    private CommonUserServiceImpl userlist;

    // RequestMapping注解，标识这是一个处理http请求的方法，路径为/hello
    // 标准化返回信息，返回值为ResultInfo<String>
    // ResultInfo是自定义的一个类，用于封装返回信息
    @RequestMapping("/hello")
    public ResultInfo<String> hello(@RequestParam String name) {
        // 调用CommonUserServiceImpl类的getUserByName方法，返回CommonUser对象
        // CommonUser对象是一个数据库表的映射类，对应数据库表CommonUser
        CommonUser user;
        if ((user = userlist.getUserByName(name) )!= null) {
            return ResultInfo.success(user.toString());
        } else {
            return ResultInfo.fail(ReturnCode.FAIL.getCode(), ReturnCode.FAIL.getMessage());
        }
    }

    // fileUp方法用于上传文件
    @RequestMapping("/fileUp")
    public ResultInfo<String> fileUp(@RequestParam MultipartFile file){
        String filepath ="D://作业//"+file.getOriginalFilename();
        byte[] bytes = null;
        try{
            bytes = file.getBytes();
        }catch (IOException e){
            log.error("fileUp error: " + e.getMessage());
        }
        if(bytes != null){
            File mfile  = new File(filepath);
            if(mfile.exists()){
                mfile.delete();
            }

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(mfile);
                fos.write(bytes,0,bytes.length);
                fos.flush();
                fos.close();
            }catch (Exception e){
                log.error("fileUp error: " + e.getMessage());
            }finally {
                try{
                    fos.close();
                }catch (Exception e){}
            }
        }
        return ResultInfo.success("success");
    }
}
