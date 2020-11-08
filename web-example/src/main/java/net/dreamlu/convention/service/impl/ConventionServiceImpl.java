package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.Convention;
import net.dreamlu.convention.mapper.ConventionMapper;
import net.dreamlu.convention.service.IConventionService;
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
public class ConventionServiceImpl extends ServiceImpl<ConventionMapper, Convention> implements IConventionService {

}
