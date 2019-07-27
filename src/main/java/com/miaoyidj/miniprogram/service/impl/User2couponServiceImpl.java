package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Coupon;
import com.miaoyidj.miniprogram.entity.User2coupon;
import com.miaoyidj.miniprogram.mapper.User2couponMapper;
import com.miaoyidj.miniprogram.service.IUser2couponService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName User2couponServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:31
 * @Version 1.0
 **/
@Service
public class User2couponServiceImpl extends ServiceImpl<User2couponMapper, User2coupon> implements IUser2couponService {
    @Override
    public List<Coupon> getUserCoupon(String userId) {
        return baseMapper.selectUserCoupon(userId);
    }
}
