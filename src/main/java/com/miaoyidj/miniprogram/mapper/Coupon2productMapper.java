package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Coupon2product;

import java.util.List;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.mapper
 * @ClassName: Coupon2productMapper
 * @Author: Kaiser
 * @Description: coupon控制券
 * @Date: 2019-08-01 17:35
 * @Version: 1.0
 */
public interface Coupon2productMapper extends BaseMapper<Coupon2product> {

    /**
     * @return 获取单项优惠商品列表
     */
    List<Integer> selectListSign();
}
