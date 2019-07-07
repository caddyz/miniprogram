package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Image;
import com.miaoyidj.miniprogram.mapper.ImageMapper;
import com.miaoyidj.miniprogram.service.IImageService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ImageServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:56
 * @Version 1.0
 **/
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {
}
