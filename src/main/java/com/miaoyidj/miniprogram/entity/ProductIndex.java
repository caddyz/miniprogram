package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ProductIndex
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/18 11:41
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIndex implements Serializable {
    private static final long serialVersionUID = 1055834323823399168L;
    private Integer iId;
    private Product product;
    private int iContro;
    private boolean iStatus;
}
