package com.miaoyidj.miniprogram.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.miaoyidj.miniprogram.entity.Product2img;
import com.miaoyidj.miniprogram.service.IProduct2imgService;
import com.miaoyidj.miniprogram.util.Constant;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName Product2imgController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/20 13:37
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product2img")
public class Product2imgController {
    @Autowired
    private IProduct2imgService product2imgService;

    /**
     *  查询商品图片
     * @param id 商品ID
     * @return
     */
    @GetMapping("/getProductImg")
    public JsonData getProductImgById(String id){
        List<Product2img> list = product2imgService.list(new QueryWrapper<Product2img>().eq("p_id", id));
        StringBuffer str = new StringBuffer();
        if (list.isEmpty()) {
            return new JsonData(null,"返回空",10,false);
        }
        for (Product2img p: list) {
            str.append("<p><img src=\"").append(p.getPiImgUrl()).append("\"/></p>");
        }
        return new JsonData(str,"返回代码", Constant.SUCCESS_CODE,true);
    }
}
