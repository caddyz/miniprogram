package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.MemberOrder;
import com.miaoyidj.miniprogram.mapper.MemberOrderMapper;
import com.miaoyidj.miniprogram.service.IMemberOrderServcie;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service.impl
 * @ClassName: MemberOrderServcieImpl
 * @Author: Kaiser
 * @Description:
 * @Date: 2019-08-08 11:11
 * @Version: 1.0
 */
@Service
public class MemberOrderServcieImpl extends ServiceImpl<MemberOrderMapper, MemberOrder> implements IMemberOrderServcie {
}
