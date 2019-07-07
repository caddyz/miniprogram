package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User2coupon
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:20
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2coupon implements Serializable {
    private static final long serialVersionUID = -3961038143586442470L;
    private int ucId;
    private int uId;
    private int cId;
}
