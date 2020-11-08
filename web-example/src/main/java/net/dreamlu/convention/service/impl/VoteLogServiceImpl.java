package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.VoteLog;
import net.dreamlu.convention.mapper.VoteLogMapper;
import net.dreamlu.convention.service.IVoteLogService;
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
public class VoteLogServiceImpl extends ServiceImpl<VoteLogMapper, VoteLog> implements IVoteLogService {

}
