package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Order;
import com.miaoyidj.miniprogram.entity.OrderSelect;

import java.util.List;

/**
 * @ClassName IOrderService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:01
 * @Version 1.0
 **/
public interface IOrderService extends IService<Order> {
    /**
     * 获取用户订单
     * @param userId 用户ID
     * @return
     */
    List<OrderSelect> getOrderByUser(String userId);
}
