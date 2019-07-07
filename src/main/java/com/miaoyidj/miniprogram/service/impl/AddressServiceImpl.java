package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Address;
import com.miaoyidj.miniprogram.mapper.AddressMapper;
import com.miaoyidj.miniprogram.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:27
 * @Version 1.0
 **/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {
}
