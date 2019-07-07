package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.User;
import com.miaoyidj.miniprogram.mapper.UserMapper;
import com.miaoyidj.miniprogram.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:24
 * @Version 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
