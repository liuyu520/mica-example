package net.dreamlu.convention.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.dreamlu.convention.mapper.AccessLogMapper;
import net.dreamlu.convention.model.AccessLog;
import net.dreamlu.convention.service.IAccessLogService;
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
public class AccessLogServiceImpl extends ServiceImpl<AccessLogMapper, AccessLog> implements IAccessLogService {
}
