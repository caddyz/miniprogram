package com.miaoyidj.miniprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.httpclient.HTTPException;
import com.github.wxpay.sdk.WXPayUtil;
import com.miaoyidj.miniprogram.entity.*;
import com.miaoyidj.miniprogram.service.IMemberOrderServcie;
import com.miaoyidj.miniprogram.service.IOrderService;
import com.miaoyidj.miniprogram.service.IRecordService;
import com.miaoyidj.miniprogram.service.IUserService;
import com.miaoyidj.miniprogram.util.Constant;
import com.miaoyidj.miniprogram.util.JsonData;
import com.miaoyidj.miniprogram.util.NetworkInterfaceUtil;
import com.miaoyidj.miniprogram.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WxPayController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/21 12:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/pay")
public class WxPayController {
    private WxPayService wxService;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IMemberOrderServcie memberOrderServcie;
    @Autowired
    private IRecordService recordService;

    @Autowired
    public WxPayController(WxPayService wxService) {
        this.wxService = wxService;
    }

    /**
     * <pre>
     * 查询订单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2)
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
     * 需要调用查询接口的情况：
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * ◆ 调用被扫支付API，返回USERPAYING的状态；
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     * 接口地址：https://api.mch.weixin.qq.com/pay/orderquery
     * </pre>
     *
     * @param transactionId 微信订单号
     * @param outTradeNo    商户系统内部的订单号，当没提供transactionId时需要传这个。
     */
    @GetMapping("/queryOrder")
    public WxPayOrderQueryResult queryOrder(@RequestParam(required = false) String transactionId,
                                            @RequestParam(required = false) String outTradeNo)
            throws WxPayException {
        return this.wxService.queryOrder(transactionId, outTradeNo);
    }

    @PostMapping("/queryOrder")
    public WxPayOrderQueryResult queryOrder(@RequestBody WxPayOrderQueryRequest wxPayOrderQueryRequest) throws WxPayException {
        return this.wxService.queryOrder(wxPayOrderQueryRequest);
    }

    /**
     * <pre>
     * 关闭订单
     * 应用场景
     * 以下情况需要调用关单接口：
     * 1. 商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
     * 2. 系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
     * 接口地址：https://api.mch.weixin.qq.com/pay/closeorder
     * 是否需要证书：   不需要。
     * </pre>
     *
     * @param outTradeNo 商户系统内部的订单号
     */
    @GetMapping("/closeOrder/{outTradeNo}")
    public WxPayOrderCloseResult closeOrder(@PathVariable String outTradeNo) throws WxPayException {
        return this.wxService.closeOrder(outTradeNo);
    }

    @PostMapping("/closeOrder")
    public WxPayOrderCloseResult closeOrder(@RequestBody WxPayOrderCloseRequest wxPayOrderCloseRequest) throws WxPayException {
        return this.wxService.closeOrder(wxPayOrderCloseRequest);
    }

    /**
     * 调用统一下单接口，并组装生成支付所需参数对象.
     *
     * @param request 统一下单请求参数
     * @param <T>     请使用{@link com.github.binarywang.wxpay.bean.order}包下的类
     * @return 返回 {@link com.github.binarywang.wxpay.bean.order}包下的类对象
     */
    @PostMapping("/createOrder")
    public <T> T createOrder(@RequestBody WxPayUnifiedOrderRequest request) throws WxPayException {
        return this.wxService.createOrder(request);
    }

    /**
     * 统一下单(详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1)
     * 在发起微信支付前，需要调用统一下单接口，获取"预支付交易会话标识"
     * 接口地址：https://api.mch.weixin.qq.com/pay/unifiedorder
     *
     * @param body 请求对象，注意一些参数如appid、mchid等不用设置，方法内会自动从配置对象中获取到（前提是对应配置中已经设置）
     */
    @PostMapping("/unifiedOrder")
    public WxPayUnifiedOrderResult unifiedOrder(@RequestBody JSONObject body) throws WxPayException {
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setNotifyUrl(Constant.NOTIFY_URL);
        request.setTradeType(Constant.TRADE_TYPE);
        request.setOpenid(body.getString("openid"));
        request.setAttach(body.getString("attach"));
        request.setBody(body.getString("bodyInfo"));
        request.setOutTradeNo(body.getString("outTradeNo"));
        request.setTotalFee(BaseWxPayRequest.yuanToFen(body.getString("totalFee")));
        System.out.println("金额："+BaseWxPayRequest.yuanToFen(body.getString("totalFee")));
        request.setSpbillCreateIp(NetworkInterfaceUtil.getMyIp());
        return this.wxService.unifiedOrder(request);
    }

    /**
     * <pre>
     * 微信支付-申请退款
     * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
     * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
     * </pre>
     *
     * @param request 请求对象
     * @return 退款操作结果
     */
    @PostMapping("/refund")
    public WxPayRefundResult refund(@RequestBody WxPayRefundRequest request) throws WxPayException {
        return this.wxService.refund(request);
    }

    /**
     * <pre>
     * 微信支付-查询退款
     * 应用场景：
     *  提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，
     *  银行卡支付的退款3个工作日后重新查询退款状态。
     * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_5
     * 接口链接：https://api.mch.weixin.qq.com/pay/refundquery
     * </pre>
     * 以下四个参数四选一
     *
     * @param transactionId 微信订单号
     * @param outTradeNo    商户订单号
     * @param outRefundNo   商户退款单号
     * @param refundId      微信退款单号
     * @return 退款信息
     */
    @GetMapping("/refundQuery")
    public WxPayRefundQueryResult refundQuery(@RequestParam(required = false) String transactionId,
                                              @RequestParam(required = false) String outTradeNo,
                                              @RequestParam(required = false) String outRefundNo,
                                              @RequestParam(required = false) String refundId)
            throws WxPayException {
        return this.wxService.refundQuery(transactionId, outTradeNo, outRefundNo, refundId);
    }

    @PostMapping("/refundQuery")
    public WxPayRefundQueryResult refundQuery(@RequestBody WxPayRefundQueryRequest wxPayRefundQueryRequest) throws WxPayException {
        return this.wxService.refundQuery(wxPayRefundQueryRequest);
    }

    /**
     * 支付回调通知处理
     * @param xmlData
     * @return
     * @throws WxPayException
     */
    @PostMapping("/notify/order")
    @Transactional(rollbackFor = Exception.class)
    public String parseOrderNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        System.out.println("回调开始！！！！");
        String attach = notifyResult.getAttach();
        String tradeNo = notifyResult.getOutTradeNo();
        if (attach.equals(Constant.RECHARGE)) {
            System.out.println("充值开始！！！！");
            try {
                MemberOrder memberOrder = memberOrderServcie.getOne(new QueryWrapper<MemberOrder>().eq("m_order_no", tradeNo));
                if (!memberOrder.isMStatus()) {
                    memberOrder.setMPayTime(TimeUtil.getCurrentTime());
                    memberOrder.setMStatus(true);
                }
                Integer uId = memberOrder.getUId();
                User user = userService.getOne(new QueryWrapper<User>().eq("u_id", uId));
                BigDecimal totalFee = memberOrder.getMTotalFee();
                BigDecimal payFee = memberOrder.getMPayFee();
                user.setUStatus(true);
                BigDecimal memberMoney = user.getUMemberMoney();
                BigDecimal decimal = memberMoney.add(totalFee);
                user.setUMemberMoney(decimal);
                userService.update(user, new UpdateWrapper<User>().eq("u_id", uId));
                Record record = new Record(null,uId,payFee,TimeUtil.getCurrentTime(),false);
                recordService.save(record);
                return WxPayNotifyResponse.success("成功");
            } catch (Exception e) {
                return WxPayNotifyResponse.fail("失败");
            }
        }
        if (attach.equals(Constant.PAY)) {
            System.out.println("支付。。。。。");
            try {
                Miaoyiorder one = orderService.getOne(new QueryWrapper<Miaoyiorder>().eq("o_number", tradeNo));
                if (one.getOStatus() == 1) {
                    one.setOPayTime(TimeUtil.getCurrentTime());
                    one.setOStatus(2);
                    orderService.update(one,new UpdateWrapper<Miaoyiorder>().eq("o_number",tradeNo));
                    int uId = one.getUId();
                    User user = userService.getOne(new QueryWrapper<User>().eq("u_id", uId));
                    BigDecimal payPrice = one.getOPayPrice();
                    int points = user.getUPoints() + payPrice.intValue();
                    System.out.println("积分："+points);
                    user.setUPoints(points);
                    userService.update(user, new UpdateWrapper<User>().eq("u_id", uId));
                    Record record = new Record(null,uId,payPrice,TimeUtil.getCurrentTime(),true);
                    recordService.save(record);
                    return WxPayNotifyResponse.success("成功");
                }
            } catch (Exception e) {
                return WxPayNotifyResponse.fail("失败");
            }
        }
        return WxPayNotifyResponse.success("成功");
    }

    /**
     * 退款回调通知处理
     * @param xmlData
     * @return
     * @throws WxPayException
     */
    @PostMapping("/notify/refund")
    public String parseRefundNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayRefundNotifyResult result = this.wxService.parseRefundNotifyResult(xmlData);
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }

    @GetMapping("/secondSign")
    public JsonData sencodeSign(String prepayId) throws Exception {
        WxPayConfig config = wxService.getConfig();
        String nonceStr = WXPayUtil.generateNonceStr();
        String signTime = String.valueOf(TimeUtil.getSignTimeStmap());
        Map<String,String> map = new HashMap<>(5);
        map.put("appId",config.getAppId());
        map.put("timeStamp",signTime);
        map.put("nonceStr",nonceStr);
        map.put("package",prepayId);
        map.put("signType","MD5");
        String signature = WXPayUtil.generateSignature(map, config.getMchKey());
        Map<String,String> data = new HashMap<>(3);
        data.put("str",nonceStr);
        data.put("signTime", signTime);
        data.put("signature",signature);
        return new JsonData(data,"二次签名",Constant.SUCCESS_CODE,true);
    }

    @GetMapping("/sendMessage")
    public void sendMessage(String orderNo) throws HTTPException, IOException {
        OrderSelect orderSelect = orderService.getOrderByOrderNo(orderNo);
        Address orderSelectAddress = orderSelect.getAddress();
        String[] params = {orderSelectAddress.getAName(),orderSelectAddress.getAAddress()+orderSelectAddress.getAAddressDetail(),orderSelectAddress.getAMobile(),orderSelect.getOUserMessage()};
        SmsSingleSender sender = new SmsSingleSender(Constant.SDKAPPID,Constant.SDKAPPKEY);
        sender.sendWithParam("86",Constant.PHONENUMBER,Constant.TEMPLATEID,params,Constant.SMSSIGN,"","");
    }
}
