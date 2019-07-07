package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Coupon;
import com.miaoyidj.miniprogram.mapper.CouponMapper;
import com.miaoyidj.miniprogram.service.ICouponService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CouponServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:26
 * @Version 1.0
 **/
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {
}
