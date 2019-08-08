package com.miaoyidj.miniprogram.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaoyidj.miniprogram.entity.Usepoints;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service
 * @ClassName: IUsepointsService
 * @Author: Kaiser
 * @Description: 可用积分接口
 * @Date: 2019-08-01 23:06
 * @Version: 1.0
 */
public interface IUsepointsService extends IService<Usepoints> {
    void checkOverdue();
}
