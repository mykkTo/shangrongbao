package com.kk.srb.core.service.impl;

import com.kk.srb.core.pojo.entity.UserLoginRecord;
import com.kk.srb.core.mapper.UserLoginRecordMapper;
import com.kk.srb.core.service.UserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author mykk
 * @since 2022-04-27
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements UserLoginRecordService {

}
