package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Coupon;
import com.miaoyidj.miniprogram.entity.User;
import com.miaoyidj.miniprogram.entity.User2coupon;
import com.miaoyidj.miniprogram.mapper.CouponMapper;
import com.miaoyidj.miniprogram.mapper.User2couponMapper;
import com.miaoyidj.miniprogram.mapper.UserMapper;
import com.miaoyidj.miniprogram.service.IUser2couponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Coupon> getUserCoupon(String userId) {
        return baseMapper.selectUserCoupon(userId);
    }

    @Override
    @Transactional
    public boolean userNewGet(User2coupon entity) {
        int cId = entity.getCId();
        Coupon coupon =  couponMapper.selectOne(new QueryWrapper<Coupon>().eq("c_id",cId));
        int uId = entity.getUId();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("u_id",uId));
        BigDecimal money = user.getUMemberMoney();
        if (money == null) {
            money = new BigDecimal("0");
        }
        user.setUMemberMoney(money.add(coupon.getCValue()));
        userMapper.update(user,new UpdateWrapper<User>().eq("u_id",uId));
        return super.save(entity);
    }
}
