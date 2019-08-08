package com.miaoyidj.miniprogram;

import com.miaoyidj.miniprogram.properties.WxPayProperties;
import com.miaoyidj.miniprogram.util.NetworkInterfaceUtil;
import com.miaoyidj.miniprogram.util.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiniprogramApplicationTests {
    @Test
    public void contextLoads() {
        WxPayProperties properties = new WxPayProperties();
        System.out.println("打印："+ properties.getAppId());
    }

}
