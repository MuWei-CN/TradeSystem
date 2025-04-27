package com.bistu.exr;

import com.bistu.exr.util.XORUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BistuTradeApplicationTests {
    @Test
    void contextLoads() {
        String account = "6500864486552331";
        String secret = XORUtil.encrypt(account);
        System.out.println(secret);
        assertEquals(account, XORUtil.decrypt(secret));
    }

}
