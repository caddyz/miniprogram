package com.miaoyidj.miniprogram.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaoyidj.miniprogram.entity.Record;
import com.miaoyidj.miniprogram.mapper.RecordMapper;
import com.miaoyidj.miniprogram.service.IRecordService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: miniprogram
 * @Package: com.miaoyidj.miniprogram.service.impl
 * @ClassName: RecordServiceImpl
 * @Author: Kaiser
 * @Description: recordService实现
 * @Date: 2019-08-01 16:01
 * @Version: 1.0
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {
}
