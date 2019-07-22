package com.miaoyidj.miniprogram.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @ClassName WxPayProperties
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/21 12:03
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "wx.pay")
@Data
public class WxPayProperties {
    /**
     * 设置微信公众号或者小程序等的appid
     */
    private String appId;

    /**
     * 微信支付商户号
     */
    private String mchId;

    /**
     * 微信支付商户密钥
     */
    private String mchKey;

    /**
     * apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定
     */
    private String keyPath;

}
