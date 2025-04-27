package com.bistu.exr;

import com.bistu.exr.service.iservice.UserService;
import com.bistu.exr.util.JwtUtil;
import com.bistu.exr.util.SpringUtil;
import com.bistu.exr.util.XORUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BistuTradeApplicationTests {
    @Test
    void XorEncrypt() {
        String account = "6500864486552331";
        String secret = XORUtil.encrypt(account);
        System.out.println(secret);
        assertEquals(account, XORUtil.decrypt(secret));
    }

    @Test
    void TestService() {
        Map<String,Object> c = JwtUtil.parseToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsicGFzc3dvcmQiOiJUU1lNUTE3NDQiLCJ1c2VyaWQiOjF9LCJleHAiOjE3NDU3NjQxODF9.AeRjcbhCWT5CpmSltZEdBzGPva8kBRPPpzQ24GdgE-k");
        System.out.println(c.get("userid"));
    }
}
