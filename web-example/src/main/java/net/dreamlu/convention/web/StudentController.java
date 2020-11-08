package net.dreamlu.convention.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.dreamlu.common.result.EasyPage;
import net.dreamlu.common.result.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;

import net.dreamlu.convention.model.Student;
import net.dreamlu.convention.service.IStudentService;
import net.dreamlu.common.base.BaseController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanjun
 * @since 2020-11-07
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

	@Autowired
	private IStudentService studentService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('student:manager')")
	public String manager() {
		return "system/student/studentList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('student:dataGrid')")
	@ResponseBody
	public EasyPage<Student> dataGrid(Student student, PageVO pageVO) {
		QueryWrapper<Student> ew = new QueryWrapper<Student>(student);
		Page<Student> pages = pageVO.toPage();
		studentService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/student/studentAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('student:add')")
	@ResponseBody
	public Object add(@Valid Student student) {
		return status(studentService.save(student));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('student:delete')")
	@ResponseBody
	public Object delete(Student student) {
		return status(studentService.removeById(student));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Student student = studentService.getById(id);
		model.addAttribute("student", student);
		return "system/student/studentEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('student:edit')")
	@ResponseBody
	public Object edit(@Valid Student student) {
		return status(studentService.updateById(student));
	}
}
