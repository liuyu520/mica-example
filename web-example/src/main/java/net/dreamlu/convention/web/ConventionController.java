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

import net.dreamlu.convention.model.Convention;
import net.dreamlu.convention.service.IConventionService;
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
@RequestMapping("/convention")
public class ConventionController extends BaseController {

	@Autowired
	private IConventionService conventionService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('convention:manager')")
	public String manager() {
		return "system/convention/conventionList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('convention:dataGrid')")
	@ResponseBody
	public EasyPage<Convention> dataGrid(Convention convention, PageVO pageVO) {
		QueryWrapper<Convention> ew = new QueryWrapper<Convention>(convention);
		Page<Convention> pages = pageVO.toPage();
		conventionService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/convention/conventionAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('convention:add')")
	@ResponseBody
	public Object add(@Valid Convention convention) {
		return status(conventionService.save(convention));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('convention:delete')")
	@ResponseBody
	public Object delete(Convention convention) {
		return status(conventionService.removeById(convention));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Convention convention = conventionService.getById(id);
		model.addAttribute("convention", convention);
		return "system/convention/conventionEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('convention:edit')")
	@ResponseBody
	public Object edit(@Valid Convention convention) {
		return status(conventionService.updateById(convention));
	}
}
