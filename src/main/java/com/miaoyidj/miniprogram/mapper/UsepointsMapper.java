package com.miaoyidj.miniprogram.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miaoyidj.miniprogram.entity.Usepoints;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.mapper
 * @ClassName: UsepointsMapper
 * @Author: Kaiser
 * @Description: 可用积分mapper
 * @Date: 2019-08-01 23:04
 * @Version: 1.0
 */
public interface UsepointsMapper extends BaseMapper<Usepoints> {

    /**
     * 定时检查过期积分
     */
    void checkOverDate();

    /**
     * 获取积分
     * @param userId 用户id
     * @return 总积分
     */
    int selectUserPoints(@Param("userId") Integer userId);
}
