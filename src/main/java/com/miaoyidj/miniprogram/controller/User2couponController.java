package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miaoyidj.miniprogram.entity.Coupon;
import com.miaoyidj.miniprogram.entity.User2coupon;
import com.miaoyidj.miniprogram.service.ICoupon2productService;
import com.miaoyidj.miniprogram.service.ICouponService;
import com.miaoyidj.miniprogram.service.IUser2couponService;
import com.miaoyidj.miniprogram.util.Constant;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import com.miaoyidj.miniprogram.util.TimeUtil;
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
    @Autowired
    private ICouponService couponService;
    @Autowired
    private ICoupon2productService coupon2productService;
    /**
     *  获取满减优惠
     */
    @GetMapping("/getFullMark")
    public JsonData getFullMark(){
        return GetResult.result(couponService.getFullMark(TimeUtil.getCurrentTime()));
    }

    /**
     *  获取单项优惠
     */
    @GetMapping("/getSignCoupon")
    public JsonData getSignCoupon(){
        return GetResult.result(couponService.getOne(new QueryWrapper<Coupon>().eq("c_id","3")));
    }

    /**
     *  获取单项优惠商品列表
     */
    @GetMapping("/getSignCouponList")
    public JsonData getSignCouponList(){
        return GetResult.result(coupon2productService.getListSign());
    }
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

    /**
     * 领取优惠
     * @param userId 用户id
     * @param couponId 优惠🆔
     * @return
     */
    @GetMapping("/userGetCoupon")
    public JsonData userGetCoupon(int userId, int couponId){
        User2coupon one = user2couponService.getOne(new QueryWrapper<User2coupon>().eq("u_id", userId).eq("c_id", couponId));
        if (one == null) {
            User2coupon user2coupon = new User2coupon(null,userId,couponId,false);
            return GetResult.boReturn(user2couponService.save(user2coupon));
        }
        return new JsonData(null,"已经领取过了", 101,false);
    }

    @GetMapping("/couponNumber")
    public JsonData couponNumber(String userId){
        int count = user2couponService.count(new QueryWrapper<User2coupon>().eq("u_id", userId).eq("uc_status", "0"));
        return new JsonData(count,"获取优惠券计数", Constant.SUCCESS_CODE,true);
    }

    /**
     * 获取会员优惠券
     * @return
     */
    @GetMapping("/getMemberCoupon")
    public JsonData getMemberCoupon(){
        return GetResult.result(couponService.getOne(new QueryWrapper<Coupon>().eq("c_id","4")));
    }

    /**
     * 领取新人优惠
     * @param userId 用户id
     * @param couponId 优惠🆔
     * @return
     */
    @GetMapping("/userGetNewCoupon")
    public JsonData userGetNewCoupon(int userId, int couponId){
        User2coupon one = user2couponService.getOne(new QueryWrapper<User2coupon>().eq("u_id", userId).eq("c_id", couponId));
        if (one == null) {
            User2coupon user2coupon = new User2coupon(null,userId,couponId,false);
            return GetResult.boReturn(user2couponService.userNewGet(user2coupon));
        }
        return new JsonData(null,"已经领取过了", 101,false);
    }
}
