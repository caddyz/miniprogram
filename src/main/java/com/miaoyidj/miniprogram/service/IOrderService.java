package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Miaoyiorder;
import com.miaoyidj.miniprogram.entity.OrderSelect;

import java.util.List;

/**
 * @ClassName IOrderService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:01
 * @Version 1.0
 **/
public interface IOrderService extends IService<Miaoyiorder> {
    /**
     * 获取用户订单
     * @param userId 用户ID
     * @return
     */
    List<OrderSelect> getOrderByUser(String userId);

    /**
     *  通过订单编号获取订单
     * @param orderNo 订单编号
     * @return
     */
    OrderSelect getOrderByOrderNo(String orderNo);
}
