package com.miaoyidj.miniprogram.controller;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/17 22:08
 * @Version 1.0
 **/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miaoyidj.miniprogram.entity.Miaoyiorder;
import com.miaoyidj.miniprogram.service.IOrderService;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import com.miaoyidj.miniprogram.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     *  生成订单
     * @param productId 商品ID
     * @param addressId 地址ID
     * @param userId 用户ID
     * @param orderNo 订单号
     * @param userMessage 备注信息
     * @param totalPrice 订单总价
     * @param payPrice 实际支付
     * @param placeTime 预约时间
     * @return
     */
    @GetMapping("/generateOrder")
    public JsonData generateOrder(int productId,int addressId, int userId,String orderNo, String userMessage, BigDecimal totalPrice,BigDecimal payPrice,String placeTime){
        Miaoyiorder order = new Miaoyiorder();
        order.setONumber(orderNo);
        order.setAId(addressId);
        order.setUId(userId);
        order.setOUserMessage(userMessage);
        order.setOTotalPrice(totalPrice);
        order.setOPayPrice(payPrice);
        order.setPId(productId);
        order.setOSubscribeTime(placeTime);
        order.setOStatus(1);
        order.setOCreateTime(TimeUtil.getCurrentTime());
        return GetResult.boReturn(orderService.save(order));
    }

    /**
     *  获取用户订单
     * @param userId 用户id
     * @return
     */
    @GetMapping("/userGetAllOrder")
    public JsonData userGetAllOrder(String userId){
        return GetResult.result(orderService.getOrderByUser(userId));
    }

    /**
     *  取消订单
     * @param orderNumber 订单号
     * @return
     */
    @GetMapping("/closeOrder")
    public JsonData closeOrder(String orderNumber){
        Miaoyiorder order = orderService.getOne(new QueryWrapper<Miaoyiorder>().eq("o_number", orderNumber));
        order.setOStatus(0);
        return GetResult.boReturn(orderService.update(order,new UpdateWrapper<Miaoyiorder>().eq("o_number", orderNumber)));
    }

    /**
     *  根据订单号查询订单
     * @param orderNo 订单号
     * @return
     */
    @GetMapping("/getOrderByOrderNo")
    public JsonData getOrderByOrderNo(String orderNo){
        return GetResult.result(orderService.getOrderByOrderNo(orderNo));
    }
}
