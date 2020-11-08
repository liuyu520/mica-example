package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.House;
import net.dreamlu.convention.mapper.HouseMapper;
import net.dreamlu.convention.service.IHouseService;
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
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

}
