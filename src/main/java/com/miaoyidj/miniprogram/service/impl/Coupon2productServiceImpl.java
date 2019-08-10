package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Coupon2product;
import com.miaoyidj.miniprogram.mapper.Coupon2productMapper;
import com.miaoyidj.miniprogram.service.ICoupon2productService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service.impl
 * @ClassName: Coupon2productServiceImpl
 * @Author: Kaiser
 * @Description:
 * @Date: 2019-08-01 17:38
 * @Version: 1.0
 */
@Service
public class Coupon2productServiceImpl extends ServiceImpl<Coupon2productMapper, Coupon2product> implements ICoupon2productService {
    @Override
    public List<Integer> getListSign() {
        return baseMapper.selectListSign();
    }
}
