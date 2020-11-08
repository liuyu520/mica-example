package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.BusinessOrderItem;
import net.dreamlu.convention.mapper.BusinessOrderItemMapper;
import net.dreamlu.convention.service.IBusinessOrderItemService;
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
public class BusinessOrderItemServiceImpl extends ServiceImpl<BusinessOrderItemMapper, BusinessOrderItem> implements IBusinessOrderItemService {

}
