package com.miaoyidj.miniprogram.controller;

import com.miaoyidj.miniprogram.entity.MemberOrder;
import com.miaoyidj.miniprogram.service.IMemberOrderServcie;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import com.miaoyidj.miniprogram.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.controller
 * @ClassName: MemberOrderController
 * @Author: Kaiser
 * @Description: 会员订单控制器
 * @Date: 2019-08-08 11:13
 * @Version: 1.0
 */
@RestController
@RequestMapping("/memberOrder")
public class MemberOrderController {
    @Autowired
    private IMemberOrderServcie memberOrderServcie;

    /**
     * 生成会员充值订单
     * @param orderNo 订单号
     * @param uId uId
     * @param totalFee 充值金额
     * @param payFee 支付金额
     * @return
     */
    @GetMapping("/generateMemberOrder")
    public JsonData generateMemberOrder(String orderNo,int uId, BigDecimal totalFee, BigDecimal payFee){
        MemberOrder memberOrder = new MemberOrder(null,orderNo,uId,totalFee,payFee, TimeUtil.getCurrentTime(),null,false);
        return GetResult.boReturn(memberOrderServcie.save(memberOrder));
    }
}
