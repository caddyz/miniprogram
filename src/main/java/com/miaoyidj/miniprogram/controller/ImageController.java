package com.miaoyidj.miniprogram.controller;


import com.miaoyidj.miniprogram.service.IImageService;
import com.miaoyidj.miniprogram.util.GetResult;
import com.miaoyidj.miniprogram.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ImageController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 11:39
 * @Version 1.0
 **/
@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IImageService imageService;
    /**
     *  查询首页轮播，热门，推荐
     * @return
     */
    @GetMapping("/getIndexProduct")
    public JsonData getIndexProduct() {
        return GetResult.result(imageService.getIndexProduct());
    }
}
