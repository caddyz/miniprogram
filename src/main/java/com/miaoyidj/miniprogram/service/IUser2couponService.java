package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Coupon;
import com.miaoyidj.miniprogram.entity.User2coupon;

import java.util.List;

/**
 * @ClassName IUser2couponService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:30
 * @Version 1.0
 **/
public interface IUser2couponService extends IService<User2coupon> {
    /**
     *  查询用户优惠券
     * @param userId 用户id
     * @return
     */
    List<Coupon> getUserCoupon(String userId);
}
