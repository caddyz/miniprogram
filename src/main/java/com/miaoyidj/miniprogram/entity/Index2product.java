package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Index2product
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 11:58
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Index2product implements Serializable {
    private static final long serialVersionUID = 7737738616479251403L;
    private Integer iId;
    private int pId;
    private int iContro;
    private int iStatus;
}
