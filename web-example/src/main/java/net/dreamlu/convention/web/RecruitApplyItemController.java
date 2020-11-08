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

import net.dreamlu.convention.model.RecruitApplyItem;
import net.dreamlu.convention.service.IRecruitApplyItemService;
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
@RequestMapping("/recruitApplyItem")
public class RecruitApplyItemController extends BaseController {

	@Autowired
	private IRecruitApplyItemService recruitApplyItemService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('recruitApplyItem:manager')")
	public String manager() {
		return "system/recruitApplyItem/recruitApplyItemList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('recruitApplyItem:dataGrid')")
	@ResponseBody
	public EasyPage<RecruitApplyItem> dataGrid(RecruitApplyItem recruitApplyItem, PageVO pageVO) {
		QueryWrapper<RecruitApplyItem> ew = new QueryWrapper<RecruitApplyItem>(recruitApplyItem);
		Page<RecruitApplyItem> pages = pageVO.toPage();
		recruitApplyItemService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/recruitApplyItem/recruitApplyItemAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('recruitApplyItem:add')")
	@ResponseBody
	public Object add(@Valid RecruitApplyItem recruitApplyItem) {
		return status(recruitApplyItemService.save(recruitApplyItem));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('recruitApplyItem:delete')")
	@ResponseBody
	public Object delete(RecruitApplyItem recruitApplyItem) {
		return status(recruitApplyItemService.removeById(recruitApplyItem));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		RecruitApplyItem recruitApplyItem = recruitApplyItemService.getById(id);
		model.addAttribute("recruitApplyItem", recruitApplyItem);
		return "system/recruitApplyItem/recruitApplyItemEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('recruitApplyItem:edit')")
	@ResponseBody
	public Object edit(@Valid RecruitApplyItem recruitApplyItem) {
		return status(recruitApplyItemService.updateById(recruitApplyItem));
	}
}
