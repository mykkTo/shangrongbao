package com.kk.srb.core.service.impl;

import com.kk.srb.core.pojo.entity.UserAccount;
import com.kk.srb.core.mapper.UserAccountMapper;
import com.kk.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author mykk
 * @since 2022-04-27
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
