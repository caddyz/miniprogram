package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Order;
import com.miaoyidj.miniprogram.mapper.OrderMapper;
import com.miaoyidj.miniprogram.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:02
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
