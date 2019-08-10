package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Coupon2product;

import java.util.List;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service
 * @ClassName: ICoupon2productService
 * @Author: Kaiser
 * @Description: coupon控制接口
 * @Date: 2019-08-01 17:37
 * @Version: 1.0
 */
public interface ICoupon2productService extends IService<Coupon2product> {
    /**
     *  获取单项商品优惠列表
     * @return
     */
    List<Integer> getListSign();
}
