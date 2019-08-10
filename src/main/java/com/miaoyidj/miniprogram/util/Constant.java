package com.miaoyidj.miniprogram.util;

/**
 * @ClassName Constant
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/17 14:58
 * @Version 1.0
 **/
public class Constant {
    public static final int SUCCESS_CODE = 1;
    public static final int FAIL_CODE = 0;
    /**
     *  数据重复
     */
    public static final int REPEAT_CODE = 3;
    /**
     *  插入数据库存在数据
     */
    public static final int ISEXIT_CODE = 4;
    /**
     * 未知错误
     */
    public static final int UNKNOW_CODE = 110;

    /**
     * 支付回调地址
     */
    public static final String NOTIFY_URL = "http://vfut3x.natappfree.cc/api/pay/notify/order";

    /**
     *  交易类型
     */
    public static final String TRADE_TYPE = "JSAPI";
    /**
     *  支付类型
     */
    public static final String RECHARGE = "RECHARGE";
    public static final String PAY = "PAY";

    /**
     * 商户openid
     */
    public static  final String OPENID = "osMvt0MZbQN9eckWNNYbAyCmyLt4";
    /**
     * 模版ID
     */
    public static final String TEMPLATE = "YQcEXq2Qc4mZNMx8BT-TGPy9d7yaai3cpsR4F-8ch_o";
    /**
     * appSercret
     */
    public static final String APPSECRET = "cd9f53f9d7b5019389dd4491981af15c";

    /**
     * 短信应用 SDK AppID SDK AppID 以1400开头
     */
    public static final int SDKAPPID = 1400241154;
    /**
     * 短信应用 SDK AppKey
     */
    public static final String SDKAPPKEY = "dd8b8c49ec66ae10be55895ecbe7394c";
    /**
     * 需要发送短信的手机号码
     */
    public static final String PHONENUMBER = "18116585239";
    /**
     * 短信模板 ID，需要在短信应用中申请
     */
    public static final int TEMPLATEID = 393210;
    /**
     * 真实的签名需要在短信控制台申请
     */
    public static final String SMSSIGN = "妙伊科技";
}
