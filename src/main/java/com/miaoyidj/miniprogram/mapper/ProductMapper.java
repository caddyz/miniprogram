package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Product;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:11
 * @Version 1.0
 **/
public interface ProductMapper extends BaseMapper<Product> {
    /**
     *  获取所有商品
     * @return
     */
    List<Product> selectAllProduct();
}
