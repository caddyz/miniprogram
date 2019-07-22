package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.config.RedisCacheMybatis;
import com.miaoyidj.miniprogram.entity.Product2img;
import org.apache.ibatis.annotations.CacheNamespace;


/**
 * @ClassName Product2imgMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/20 13:29
 * @Version 1.0
 **/
@CacheNamespace(implementation = RedisCacheMybatis.class)
public interface Product2imgMapper extends BaseMapper<Product2img> {
}
