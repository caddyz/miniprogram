package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miaoyidj.miniprogram.entity.Address;
import com.miaoyidj.miniprogram.service.IAddressService;
import com.miaoyidj.miniprogram.util.Constant;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AddressController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    /**
     *  获取用户的所有地址
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getUserAddress")
    public JsonData getUserAddress(String userId){
        return GetResult.result(addressService.list(new QueryWrapper<Address>().eq("u_id",userId)));
    }

    /**
     *  删除地址
     * @param addressId 地址ID
     * @return
     */
    @GetMapping("/deleteAddress")
    public JsonData deleteAddress(String addressId){
        return GetResult.boReturn(addressService.remove(new QueryWrapper<Address>().eq("a_id",addressId)));
    }

    /**
     *  修改地址信息
     * @param addressId 地址ID
     * @param addressInfo 城区
     * @param addressDetailInfo 详细地址
     * @param addressName 联系人
     * @param addressPhone 电话
     * @return
     */
    @GetMapping("/updateAddress")
    public JsonData updateAddress(String addressId,String addressInfo,String addressDetailInfo,String addressName,String addressPhone){
        Address address = addressService.getOne(new QueryWrapper<Address>().eq("a_id", addressId));
        if (address == null) {
            return new JsonData(null,"未知错误", Constant.UNKNOW_CODE,false);
        }
        address.setAAddress(addressInfo);
        address.setAAddressDetail(addressDetailInfo);
        address.setAName(addressName);
        address.setAMobile(addressPhone);
        return GetResult.boReturn(addressService.update(address,new UpdateWrapper<Address>().eq("a_id",addressId)));
    }

    /**
     *  增加地址
     * @param address 地址
     * @param addressDetail 详细地址
     * @param addressPhone 手机
     * @param addressName 联系人
     * @param uid 用户id
     * @return
     */
    @GetMapping("/addAddress")
    public JsonData addAddress(String address,String addressDetail,String addressPhone,String addressName,int uid){
        Address add = new Address(null,address,addressDetail,uid,addressPhone,addressName);
        return GetResult.boReturn(addressService.save(add));
    }
}
