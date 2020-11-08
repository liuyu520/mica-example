package net.dreamlu.convention.service.impl;

import net.dreamlu.convention.model.Student;
import net.dreamlu.convention.mapper.StudentMapper;
import net.dreamlu.convention.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
