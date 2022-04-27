package com.kk.srb.core.service.impl;

import com.kk.srb.core.pojo.entity.UserInfo;
import com.kk.srb.core.mapper.UserInfoMapper;
import com.kk.srb.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author mykk
 * @since 2022-04-27
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
