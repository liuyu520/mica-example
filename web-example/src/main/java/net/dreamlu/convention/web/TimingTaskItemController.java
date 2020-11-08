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

import net.dreamlu.convention.model.TimingTaskItem;
import net.dreamlu.convention.service.ITimingTaskItemService;
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
@RequestMapping("/timingTaskItem")
public class TimingTaskItemController extends BaseController {

	@Autowired
	private ITimingTaskItemService timingTaskItemService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('timingTaskItem:manager')")
	public String manager() {
		return "system/timingTaskItem/timingTaskItemList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('timingTaskItem:dataGrid')")
	@ResponseBody
	public EasyPage<TimingTaskItem> dataGrid(TimingTaskItem timingTaskItem, PageVO pageVO) {
		QueryWrapper<TimingTaskItem> ew = new QueryWrapper<TimingTaskItem>(timingTaskItem);
		Page<TimingTaskItem> pages = pageVO.toPage();
		timingTaskItemService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/timingTaskItem/timingTaskItemAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('timingTaskItem:add')")
	@ResponseBody
	public Object add(@Valid TimingTaskItem timingTaskItem) {
		return status(timingTaskItemService.save(timingTaskItem));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('timingTaskItem:delete')")
	@ResponseBody
	public Object delete(TimingTaskItem timingTaskItem) {
		return status(timingTaskItemService.removeById(timingTaskItem));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		TimingTaskItem timingTaskItem = timingTaskItemService.getById(id);
		model.addAttribute("timingTaskItem", timingTaskItem);
		return "system/timingTaskItem/timingTaskItemEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('timingTaskItem:edit')")
	@ResponseBody
	public Object edit(@Valid TimingTaskItem timingTaskItem) {
		return status(timingTaskItemService.updateById(timingTaskItem));
	}
}
