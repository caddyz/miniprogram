package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Button;
import com.miaoyidj.miniprogram.mapper.ButtonMapper;
import com.miaoyidj.miniprogram.service.IButtonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service.impl
 * @ClassName: ButtonServiceImpl
 * @Author: Kaiser
 * @Description: button实现类
 * @Date: 2019-08-01 17:11
 * @Version: 1.0
 */
@Service
public class ButtonServiceImpl extends ServiceImpl<ButtonMapper, Button> implements IButtonService {
    @Override
    public List<Button> getAllButton() {
        return baseMapper.selectAllButton();
    }
}
