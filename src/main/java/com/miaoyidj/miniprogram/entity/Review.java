package com.miaoyidj.miniprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Review
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 12:16
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {
    private static final long serialVersionUID = -1971217997842081928L;
    private Integer rId;
    private int rRate;
    private String rContent;
    private String rReviewTime;
    private Integer uId;
    private Integer pId;
}
