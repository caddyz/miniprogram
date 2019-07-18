package com.miaoyidj.miniprogram.controller;

import com.miaoyidj.miniprogram.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CouponController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 10:23
 * @Version 1.0
 **/
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private ICouponService couponService;
}
