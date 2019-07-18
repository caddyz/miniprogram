package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Address
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 11:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = -6932944096179429104L;
    private Integer aId;
    private String aAddress;
    private String aAddressDetail;
    private int uId;
    private String aMobile;
    private String aName;
}
