package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Coupon;

/**
 * @ClassName ICouponService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:24
 * @Version 1.0
 **/
public interface ICouponService extends IService<Coupon> {
    /**
     *  获取有效奇的满减优惠券
     * @param time 时间
     * @return
     */
    Coupon getFullMark(String time);
}
