package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Review;
import com.miaoyidj.miniprogram.entity.UserReview;
import com.miaoyidj.miniprogram.mapper.ReviewMapper;
import com.miaoyidj.miniprogram.service.IReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ReviewServiceImpl
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 14:20
 * @Version 1.0
 **/
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements IReviewService {
    @Override
    public UserReview getLastReview() {
        return baseMapper.selectLastReview();
    }

    @Override
    public List<UserReview> getAllReview(String productId) {
        return baseMapper.selectAllReview(productId);
    }
}
