package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Miaoyiorder;
import com.miaoyidj.miniprogram.entity.OrderSelect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/7/7 13:58
 * @Version 1.0
 **/
public interface OrderMapper extends BaseMapper<Miaoyiorder> {
    /**
     *  通过userId查询订单
     * @param userId
     * @return
     */
    List<OrderSelect> selectOrderByUser(@Param("userId") String userId);

    /**
     *  通过订单号查询订单
     * @param orderNo
     * @return
     */
    OrderSelect selectOrderByOrderNo(@Param("orderNo") String orderNo);
}
