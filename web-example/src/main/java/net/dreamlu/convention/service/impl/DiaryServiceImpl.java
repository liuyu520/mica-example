package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.Diary;
import net.dreamlu.convention.mapper.DiaryMapper;
import net.dreamlu.convention.service.IDiaryService;
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
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements IDiaryService {

}
