package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miaoyidj.miniprogram.entity.Record;
import com.miaoyidj.miniprogram.entity.User;
import com.miaoyidj.miniprogram.service.IRecordService;
import com.miaoyidj.miniprogram.service.IUserService;
import com.miaoyidj.miniprogram.util.*;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/17 14:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRecordService recordService;

    /**
     *  根据id查询用户
     * @param openid 用户id
     * @return
     */
    @GetMapping("/getUserInfo")
    public JsonData getUserInfo(String openid) {
        try {
            User one = userService.getOne(new QueryWrapper<User>().eq("u_openid", openid));
            return GetResult.result(one);
        } catch (MyBatisSystemException e) {
            return new JsonData(null,"数据库出现重复数据",Constant.REPEAT_CODE,false);
        }
    }

    /**
     *  登陆注册
     * @param openid 微信openid
     * @param username 昵称
     * @return
     */
    @GetMapping("/login")
    public JsonData login(String openid,String username,String avatar){
        User one = userService.getOne(new QueryWrapper<User>().eq("u_openid", openid));
        if (one == null) {
            User user = new User(null,username,false,openid,new BigDecimal("0"),avatar,0,TimeUtil.getCurrentTime());
            boolean b = userService.save(user);
            return GetResult.boReturn(b);
        }
        return new JsonData(null,"数据库已存在数据",Constant.ISEXIT_CODE,false);
    }

    /**
     *  会员充值并增加记录
     * @param userId 用户id
     * @param quota 金额
     * @return
     */
    @Transactional
    @GetMapping("/member")
    public JsonData toBeMember(int userId, String quota){
        User user = userService.getOne(new QueryWrapper<User>().eq("u_id", userId));
        user.setUStatus(true);
        user.setUMemberMoney(new BigDecimal(quota));
        Record record = new Record(null,userId,new BigDecimal(quota),TimeUtil.getCurrentTime(),false);
        return GetResult.boReturn(userService.update(user,new UpdateWrapper<User>().eq("u_id", userId)) && recordService.save(record));
    }

    /**
     * 检查会员信息
     * @param userId 用户id
     * @return
     */
    @GetMapping("/memberCheck")
    public JsonData memberCheck(String userId){
        User one = userService.getOne(new QueryWrapper<User>().eq("u_id", userId));
        return GetResult.result(one);
    }

    /**
     *  会员余额支付
     * @param id 用户对象
     * @return
     */
    @GetMapping("/memberPay")
    public JsonData memberPay(int id,String name,String openid,boolean status,String meney,int points,String avater,String time){
        User user = new User(id,name,status,openid,new BigDecimal(meney),avater,points,time);
        boolean update = userService.update(user, new UpdateWrapper<User>().eq("u_id", id));
        return GetResult.boReturn(update);
    }

    @GetMapping("/usePoints")
    public JsonData usePoints(String userId, int points){
        User one = userService.getOne(new QueryWrapper<User>().eq("u_id", userId));
        one.setUPoints(one.getUPoints() - points);
        return GetResult.boReturn(userService.update(one,new UpdateWrapper<User>().eq("u_id",userId)));
    }

    @GetMapping("/getUserInfoById")
    public JsonData getUserInfoById(int uid) {
        try {
            User one = userService.getOne(new QueryWrapper<User>().eq("u_id", uid));
            return GetResult.result(one);
        } catch (MyBatisSystemException e) {
            return new JsonData(null,"数据库出现重复数据",Constant.REPEAT_CODE,false);
        }
    }
}
