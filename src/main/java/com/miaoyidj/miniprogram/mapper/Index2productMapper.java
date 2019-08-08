package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Index2product;
import com.miaoyidj.miniprogram.entity.ProductIndex;

import java.util.List;

/**
 * @ClassName Index2productMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:53
 * @Version 1.0
 **/
public interface Index2productMapper extends BaseMapper<Index2product> {
    /**
     *  查询首页推荐产品
     * @return
     */
    List<ProductIndex> selectIndexProduct();
}
