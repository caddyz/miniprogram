package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Index2product;
import com.miaoyidj.miniprogram.entity.ProductIndex;
import com.miaoyidj.miniprogram.mapper.Index2productMapper;
import com.miaoyidj.miniprogram.service.IIndex2productService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName Index2productServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:56
 * @Version 1.0
 **/
@Service
public class Index2productServiceImpl extends ServiceImpl<Index2productMapper, Index2product> implements IIndex2productService {
    @Override
    public List<ProductIndex> getIndexProduct() {
        return baseMapper.selectIndexProduct();
    }
}
