package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.entity
 * @ClassName: Miaoyirules
 * @Author: Kaiser
 * @Description: 积分规则
 * @Date: 2019-08-01 19:23
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Miaoyirules implements Serializable {
    private static final long serialVersionUID = 2645470501058477728L;
    private Integer rId;
    private int rDenPoints;
    private int rMolPoints;
    private String rPointsRules;
}
