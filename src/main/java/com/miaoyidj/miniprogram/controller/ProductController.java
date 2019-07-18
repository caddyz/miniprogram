package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.miaoyidj.miniprogram.entity.Product;
import com.miaoyidj.miniprogram.service.IProductService;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/17 17:14
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 获取所有商品
     * @return
     */
    @GetMapping("/getAllProduct")
    public JsonData getAllProduct(){
        List<Product> allProduct = productService.getAllProduct();
        return GetResult.result(allProduct);
    }

    /**
     *  获取商品详情
     * @param id 商品id
     * @return
     */
    @GetMapping("/getProductById")
    public JsonData getProductById(String id) {
        Product one = productService.getOne(new QueryWrapper<Product>().eq("p_id", id));
        return GetResult.result(one);
    }
}
