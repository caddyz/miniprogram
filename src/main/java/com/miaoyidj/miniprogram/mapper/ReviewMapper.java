package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Review;
import com.miaoyidj.miniprogram.entity.UserReview;

import java.util.List;

/**
 * @ClassName ReviewMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:17
 * @Version 1.0
 **/
public interface ReviewMapper extends BaseMapper<Review> {
    /**
     * 查询最近的好评
     * @return
     */
    Review selectLastReview();

    /**
     *  查询所有评价
     * @return
     */
    List<UserReview> selectAllReview();
}
