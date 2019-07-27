package com.miaoyidj.miniprogram;

import com.miaoyidj.miniprogram.util.NetworkInterfaceUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiniprogramApplicationTests {
    @Test
    public void contextLoads() {
        System.out.println("打印："+ NetworkInterfaceUtil.getMyIp());
    }

}
