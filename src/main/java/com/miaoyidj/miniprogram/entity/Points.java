package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: Points
 * @Author: Kaiser
 * @Description: 积分
 * @Date: 2019-08-01 16:52
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Points implements Serializable {
    private static final long serialVersionUID = -2405343418027555745L;
    private Integer pId;
    private Integer uId;
    private int pPoints;
    private String pCreatetime;
    private String pOverduetime;
    private String pRemark;
}
