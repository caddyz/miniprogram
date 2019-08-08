package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Points;
import com.miaoyidj.miniprogram.mapper.PointsMapper;
import com.miaoyidj.miniprogram.service.IPointsService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service.impl
 * @ClassName: PointsServiceImpl
 * @Author: Kaiser
 * @Description: points接口实现
 * @Date: 2019-08-01 16:58
 * @Version: 1.0
 */
@Service
public class PointsServiceImpl extends ServiceImpl<PointsMapper, Points> implements IPointsService {
}
