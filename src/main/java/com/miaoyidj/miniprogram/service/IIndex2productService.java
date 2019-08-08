package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Index2product;
import com.miaoyidj.miniprogram.entity.ProductIndex;

import java.util.List;

/**
 * @ClassName IIndex2productService
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:54
 * @Version 1.0
 **/
public interface IIndex2productService extends IService<Index2product> {
    /**
     *  获取首页分类数据
     * @return
     */
    List<ProductIndex> getIndexProduct();
}
