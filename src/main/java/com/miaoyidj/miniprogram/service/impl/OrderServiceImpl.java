package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Miaoyiorder;
import com.miaoyidj.miniprogram.entity.OrderSelect;
import com.miaoyidj.miniprogram.mapper.OrderMapper;
import com.miaoyidj.miniprogram.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:02
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Miaoyiorder> implements IOrderService {
    @Override
    public List<OrderSelect> getOrderByUser(String userId) {
        return baseMapper.selectOrderByUser(userId);
    }

    @Override
    public OrderSelect getOrderByOrderNo(String orderNo) {
        return baseMapper.selectOrderByOrderNo(orderNo);
    }
}
