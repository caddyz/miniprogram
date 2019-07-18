package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName Product
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:12
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1675646221938920406L;
    private Integer pId;
    private String pName;
    private BigDecimal pPrice;
    private String pCover;
    private String pIntro;
}
