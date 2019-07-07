package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Order2productMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:10
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order2product implements Serializable {
    private static final long serialVersionUID = -3618961564250355353L;
    private int opId;
    private int oNumber;
    private int pId;
}
