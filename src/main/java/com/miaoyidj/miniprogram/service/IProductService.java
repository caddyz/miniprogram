package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Product;

import java.util.List;

/**
 * @ClassName IProductService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:13
 * @Version 1.0
 **/
public interface IProductService extends IService<Product> {
    /**
     *  获取商品所有信息
     * @return
     */
    List<Product> getAllProduct();
}
