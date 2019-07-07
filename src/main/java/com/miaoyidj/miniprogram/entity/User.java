package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:18
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -6339299387672128091L;
    private int uId;
    private String uName;
    private boolean uStatus;
    private String uOpenid;
    private int uPoints;
}
