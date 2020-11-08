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

import net.dreamlu.convention.model.TestToBoy;
import net.dreamlu.convention.service.ITestToBoyService;
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
@RequestMapping("/testToBoy")
public class TestToBoyController extends BaseController {

	@Autowired
	private ITestToBoyService testToBoyService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('testToBoy:manager')")
	public String manager() {
		return "system/testToBoy/testToBoyList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('testToBoy:dataGrid')")
	@ResponseBody
	public EasyPage<TestToBoy> dataGrid(TestToBoy testToBoy, PageVO pageVO) {
		QueryWrapper<TestToBoy> ew = new QueryWrapper<TestToBoy>(testToBoy);
		Page<TestToBoy> pages = pageVO.toPage();
		testToBoyService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/testToBoy/testToBoyAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('testToBoy:add')")
	@ResponseBody
	public Object add(@Valid TestToBoy testToBoy) {
		return status(testToBoyService.save(testToBoy));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('testToBoy:delete')")
	@ResponseBody
	public Object delete(TestToBoy testToBoy) {
		return status(testToBoyService.removeById(testToBoy));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		TestToBoy testToBoy = testToBoyService.getById(id);
		model.addAttribute("testToBoy", testToBoy);
		return "system/testToBoy/testToBoyEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('testToBoy:edit')")
	@ResponseBody
	public Object edit(@Valid TestToBoy testToBoy) {
		return status(testToBoyService.updateById(testToBoy));
	}
}
