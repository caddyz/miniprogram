package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miaoyidj.miniprogram.entity.User2coupon;
import com.miaoyidj.miniprogram.service.IUser2couponService;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName User2couponController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 10:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user2coupon")
public class User2couponController {
    @Autowired
    private IUser2couponService user2couponService;

    /**
     *  获取用户优惠券
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getUserCoupon")
    public JsonData getUserCoupon(String userId){
        return GetResult.result(user2couponService.getUserCoupon(userId));
    }

    /**
     *  使用优惠券
     * @param userId 用户id
     * @param couponId 优惠券id
     * @return
     */
    @GetMapping("/useCoupon")
    public JsonData useCoupon(int userId,int couponId){
        User2coupon user2coupon = user2couponService.getOne(new QueryWrapper<User2coupon>().eq("u_id", userId).eq("c_id",couponId));
        user2coupon.setUcStatus(false);
        return GetResult.boReturn(user2couponService.update(user2coupon,new UpdateWrapper<User2coupon>().eq("u_id", userId).eq("c_id",couponId)));
    }
}
