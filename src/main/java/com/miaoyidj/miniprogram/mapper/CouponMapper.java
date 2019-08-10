package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Coupon;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName CouponMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:30
 * @Version 1.0
 **/
public interface CouponMapper extends BaseMapper<Coupon> {
    /**
     * 获取满减优惠券
     * @param time 当前时间
     * @return
     */
    Coupon selectFullMark(@Param("time") String time);
}
