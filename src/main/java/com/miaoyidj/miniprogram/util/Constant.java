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
    public static final String NOTIFY_URL = "https://miniapp.miaoyidj.com/api/pay/notify/order";

    /**
     *  交易类型
     */
    public static final String TRADE_TYPE = "JSAPI";
    /**
     *  支付类型
     */
    public static final String RECHARGE = "RECHARGE";
    public static final String PAY = "PAY";


}
