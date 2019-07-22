package com.miaoyidj.miniprogram.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @ClassName WxMaProperties
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/21 20:31
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMaProperties {
    private List<Config> configs;
    @Data
    public static class Config {
        /**
         * 设置微信小程序的appid
         */
        private String appid;

        /**
         * 设置微信小程序的Secret
         */
        private String secret;

        /**
         * 消息格式，XML或者JSON
         */
        private String msgDataFormat;
    }
}
