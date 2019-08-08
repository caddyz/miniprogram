package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Usepoints;
import com.miaoyidj.miniprogram.mapper.UsepointsMapper;
import com.miaoyidj.miniprogram.service.IUsepointsService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service.impl
 * @ClassName: UsepointsServiceImpl
 * @Author: Kaiser
 * @Description:
 * @Date: 2019-08-01 23:07
 * @Version: 1.0
 */
@Service
public class UsepointsServiceImpl extends ServiceImpl<UsepointsMapper, Usepoints> implements IUsepointsService {
    @Override
    public void checkOverdue() {
        baseMapper.checkOverDate();
    }
}
