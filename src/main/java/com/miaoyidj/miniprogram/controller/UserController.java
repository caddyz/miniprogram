package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miaoyidj.miniprogram.entity.User;
import com.miaoyidj.miniprogram.service.IUserService;
import com.miaoyidj.miniprogram.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     *  根据id查询用户
     * @param id 用户id
     * @return
     */
    @GetMapping("/getUserInfo")
    public JsonData getUserInfo(String id) {
        System.out.println("生成订单号："+IdUtil.getInstance().generateOrderNo());
        System.out.println("生成ID："+IdUtil.getInstance().generateIdNo());
        System.out.println("获取当前时间："+ TimeUtil.getCurrentTime());
        System.out.println("生成时间戳："+TimeUtil.getSignTimeStmap());
        User one = userService.getOne(new QueryWrapper<User>().eq("u_id", id));
        return GetResult.result(one);
    }

    /**
     *  登陆注册
     * @param openid 微信openid
     * @param username 昵称
     * @return
     */
    @GetMapping("/login")
    public JsonData login(String openid,String username){
        User user = new User(null,username,false,openid,0,0,"ssss");
        boolean b = userService.save(user);
        return GetResult.boReturn(b);
    }

    /**
     *  充值会员
     * @param userId
     * @return
     */
    @GetMapping("/member")
    public JsonData toBeMember(String userId, int quota){
        User user = userService.getOne(new QueryWrapper<User>().eq("u_id", userId));
        user.setUStatus(true);
        user.setUPoints(quota);
        user.setUPoints(quota);
        return GetResult.boReturn(userService.update(user,new UpdateWrapper<User>().eq("u_id", userId)));
    }


}
