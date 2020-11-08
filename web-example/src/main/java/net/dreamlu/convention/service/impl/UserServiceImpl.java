package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.User;
import net.dreamlu.convention.mapper.UserMapper;
import net.dreamlu.convention.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanjun
 * @since 2020-11-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
