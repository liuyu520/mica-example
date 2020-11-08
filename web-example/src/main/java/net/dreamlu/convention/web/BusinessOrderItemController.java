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

import net.dreamlu.convention.model.BusinessOrderItem;
import net.dreamlu.convention.service.IBusinessOrderItemService;
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
@RequestMapping("/businessOrderItem")
public class BusinessOrderItemController extends BaseController {

	@Autowired
	private IBusinessOrderItemService businessOrderItemService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('businessOrderItem:manager')")
	public String manager() {
		return "system/businessOrderItem/businessOrderItemList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('businessOrderItem:dataGrid')")
	@ResponseBody
	public EasyPage<BusinessOrderItem> dataGrid(BusinessOrderItem businessOrderItem, PageVO pageVO) {
		QueryWrapper<BusinessOrderItem> ew = new QueryWrapper<BusinessOrderItem>(businessOrderItem);
		Page<BusinessOrderItem> pages = pageVO.toPage();
		businessOrderItemService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/businessOrderItem/businessOrderItemAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('businessOrderItem:add')")
	@ResponseBody
	public Object add(@Valid BusinessOrderItem businessOrderItem) {
		return status(businessOrderItemService.save(businessOrderItem));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('businessOrderItem:delete')")
	@ResponseBody
	public Object delete(BusinessOrderItem businessOrderItem) {
		return status(businessOrderItemService.removeById(businessOrderItem));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		BusinessOrderItem businessOrderItem = businessOrderItemService.getById(id);
		model.addAttribute("businessOrderItem", businessOrderItem);
		return "system/businessOrderItem/businessOrderItemEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('businessOrderItem:edit')")
	@ResponseBody
	public Object edit(@Valid BusinessOrderItem businessOrderItem) {
		return status(businessOrderItemService.updateById(businessOrderItem));
	}
}
