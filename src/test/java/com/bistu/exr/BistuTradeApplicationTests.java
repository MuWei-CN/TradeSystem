package com.bistu.exr;

import com.bistu.exr.util.EncodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.bistu.exr.dao.dataEnum.User.UserTypeEnum.PERSONAL;

@SpringBootTest
class BistuTradeApplicationTests {
    @Test
    void contextLoads() {
        System.out.println(EncodeUtil.decode("VFNZTVExNzQ0"));
    }

}
