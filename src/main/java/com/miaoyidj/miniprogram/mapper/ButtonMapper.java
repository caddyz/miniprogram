package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Button;

import java.util.List;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.mapper
 * @ClassName: ButtonMapper
 * @Author: Kaiser
 * @Description: 会员充值mapper
 * @Date: 2019-08-01 17:09
 * @Version: 1.0
 */
public interface ButtonMapper extends BaseMapper<Button> {
    /**
     *  获取充值按钮
     * @return
     */
    List<Button> selectAllButton();
}
