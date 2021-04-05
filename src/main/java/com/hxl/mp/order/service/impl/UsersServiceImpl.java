package com.hxl.mp.order.service.impl;

import com.hxl.mp.order.entity.Users;
import com.hxl.mp.order.mapper.UsersMapper;
import com.hxl.mp.order.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Huangxl
 * @since 2021-04-05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
