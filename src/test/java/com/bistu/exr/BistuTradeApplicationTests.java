package com.bistu.exr;

import com.bistu.exr.util.EncodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BistuTradeApplicationTests {
    @Test
    void contextLoads() {
        System.out.println(EncodeUtil.convertMD5("VFNZTVExNzQ0"));
    }

}
