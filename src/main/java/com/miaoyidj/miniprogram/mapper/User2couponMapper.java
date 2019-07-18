package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.User2coupon;
import com.miaoyidj.miniprogram.entity.UserCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName User2couponMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:29
 * @Version 1.0
 **/
public interface User2couponMapper extends BaseMapper<User2coupon> {
    /**
     *  查询用户优惠券
     * @param userId 用户id
     * @return
     */
    List<UserCoupon> selectUserCoupon(@Param("userId") String userId);
}
