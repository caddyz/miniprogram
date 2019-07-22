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
import com.miaoyidj.miniprogram.entity.Order;
import com.miaoyidj.miniprogram.service.IOrderService;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.IdUtil;
import com.miaoyidj.miniprogram.util.JsonData;
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
     * @param userMessage 备注信息
     * @param totalPrice 订单总价
     * @param payPrice 实际支付
     * @return
     */
    @GetMapping("/generateOrder")
    public JsonData generateOrder(int productId,int addressId, int userId, String userMessage, BigDecimal totalPrice,BigDecimal payPrice){
        Order order = new Order();
        int orderId = Integer.parseInt(IdUtil.getInstance().generateOrderNo());
        order.setONumber(orderId);
        order.setAId(addressId);
        order.setUId(userId);
        order.setOUserMessage(userMessage);
        order.setOTotalPrice(totalPrice);
        order.setOPayPrice(payPrice);
        order.setPId(productId);
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
        Order order = orderService.getOne(new QueryWrapper<Order>().eq("o_number", orderNumber));
        order.setOStatus(0);
        return GetResult.boReturn(orderService.update(order,new UpdateWrapper<Order>().eq("o_number", orderNumber)));
    }
}
