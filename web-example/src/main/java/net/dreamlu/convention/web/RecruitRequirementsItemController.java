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

import net.dreamlu.convention.model.RecruitRequirementsItem;
import net.dreamlu.convention.service.IRecruitRequirementsItemService;
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
@RequestMapping("/recruitRequirementsItem")
public class RecruitRequirementsItemController extends BaseController {

	@Autowired
	private IRecruitRequirementsItemService recruitRequirementsItemService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('recruitRequirementsItem:manager')")
	public String manager() {
		return "system/recruitRequirementsItem/recruitRequirementsItemList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('recruitRequirementsItem:dataGrid')")
	@ResponseBody
	public EasyPage<RecruitRequirementsItem> dataGrid(RecruitRequirementsItem recruitRequirementsItem, PageVO pageVO) {
		QueryWrapper<RecruitRequirementsItem> ew = new QueryWrapper<RecruitRequirementsItem>(recruitRequirementsItem);
		Page<RecruitRequirementsItem> pages = pageVO.toPage();
		recruitRequirementsItemService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/recruitRequirementsItem/recruitRequirementsItemAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('recruitRequirementsItem:add')")
	@ResponseBody
	public Object add(@Valid RecruitRequirementsItem recruitRequirementsItem) {
		return status(recruitRequirementsItemService.save(recruitRequirementsItem));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('recruitRequirementsItem:delete')")
	@ResponseBody
	public Object delete(RecruitRequirementsItem recruitRequirementsItem) {
		return status(recruitRequirementsItemService.removeById(recruitRequirementsItem));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		RecruitRequirementsItem recruitRequirementsItem = recruitRequirementsItemService.getById(id);
		model.addAttribute("recruitRequirementsItem", recruitRequirementsItem);
		return "system/recruitRequirementsItem/recruitRequirementsItemEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('recruitRequirementsItem:edit')")
	@ResponseBody
	public Object edit(@Valid RecruitRequirementsItem recruitRequirementsItem) {
		return status(recruitRequirementsItemService.updateById(recruitRequirementsItem));
	}
}
