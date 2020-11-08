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

import net.dreamlu.convention.model.MidTestConvention;
import net.dreamlu.convention.service.IMidTestConventionService;
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
@RequestMapping("/midTestConvention")
public class MidTestConventionController extends BaseController {

	@Autowired
	private IMidTestConventionService midTestConventionService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('midTestConvention:manager')")
	public String manager() {
		return "system/midTestConvention/midTestConventionList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('midTestConvention:dataGrid')")
	@ResponseBody
	public EasyPage<MidTestConvention> dataGrid(MidTestConvention midTestConvention, PageVO pageVO) {
		QueryWrapper<MidTestConvention> ew = new QueryWrapper<MidTestConvention>(midTestConvention);
		Page<MidTestConvention> pages = pageVO.toPage();
		midTestConventionService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/midTestConvention/midTestConventionAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('midTestConvention:add')")
	@ResponseBody
	public Object add(@Valid MidTestConvention midTestConvention) {
		return status(midTestConventionService.save(midTestConvention));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('midTestConvention:delete')")
	@ResponseBody
	public Object delete(MidTestConvention midTestConvention) {
		return status(midTestConventionService.removeById(midTestConvention));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		MidTestConvention midTestConvention = midTestConventionService.getById(id);
		model.addAttribute("midTestConvention", midTestConvention);
		return "system/midTestConvention/midTestConventionEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('midTestConvention:edit')")
	@ResponseBody
	public Object edit(@Valid MidTestConvention midTestConvention) {
		return status(midTestConventionService.updateById(midTestConvention));
	}
}
