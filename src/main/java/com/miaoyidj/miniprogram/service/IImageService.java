package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Image;
import com.miaoyidj.miniprogram.entity.ProductIndex;

import java.util.List;

/**
 * @ClassName IImageService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:54
 * @Version 1.0
 **/
public interface IImageService extends IService<Image> {
    List<ProductIndex> getIndexProduct();
}
