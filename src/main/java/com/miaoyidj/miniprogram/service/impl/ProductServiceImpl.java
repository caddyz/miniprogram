package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Product;
import com.miaoyidj.miniprogram.mapper.ProductMapper;
import com.miaoyidj.miniprogram.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:15
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Override
    public List<Product> getAllProduct() {
        return baseMapper.selectAllProduct();
    }
}
