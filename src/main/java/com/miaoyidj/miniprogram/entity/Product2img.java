package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Product2img
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/20 13:27
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product2img implements Serializable {
    private static final long serialVersionUID = 9172137406182617155L;
    private Integer piId;
    private String piImgUrl;
    private int pId;
}
