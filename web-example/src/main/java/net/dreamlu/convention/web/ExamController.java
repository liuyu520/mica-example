package net.dreamlu.convention.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.dreamlu.common.base.BaseController;
import net.dreamlu.common.result.EasyPage;
import net.dreamlu.common.result.PageVO;
import net.dreamlu.convention.model.Exam;
import net.dreamlu.convention.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanjun
 * @since 2020-11-07
 */
@Controller
@RequestMapping("/exam")
public class ExamController extends BaseController {

	@Autowired
	private IExamService examService;

	@GetMapping("/manager")
	public String manager() {
		return "system/exam/examList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<Exam> dataGrid(Exam exam, PageVO pageVO) {
		QueryWrapper<Exam> ew = new QueryWrapper<Exam>(exam);
		Page<Exam> pages = pageVO.toPage();
		examService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/exam/examAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid Exam exam) {
		return status(examService.save(exam));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(Exam exam) {
		return status(examService.removeById(exam));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Exam exam = examService.getById(id);
		model.addAttribute("exam", exam);
		return "system/exam/examEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid Exam exam) {
		return status(examService.updateById(exam));
	}
}
