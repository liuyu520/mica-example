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

import javax.validation.Valid;

import net.dreamlu.convention.model.TimingReminder;
import net.dreamlu.convention.service.ITimingReminderService;
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
@RequestMapping("/timingReminder")
public class TimingReminderController extends BaseController {

	@Autowired
	private ITimingReminderService timingReminderService;

	@GetMapping("/manager")
	public String manager() {
		return "system/timingReminder/timingReminderList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<TimingReminder> dataGrid(TimingReminder timingReminder, PageVO pageVO) {
		QueryWrapper<TimingReminder> ew = new QueryWrapper<TimingReminder>(timingReminder);
		Page<TimingReminder> pages = pageVO.toPage();
		timingReminderService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/timingReminder/timingReminderAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid TimingReminder timingReminder) {
		return status(timingReminderService.save(timingReminder));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(TimingReminder timingReminder) {
		return status(timingReminderService.removeById(timingReminder));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		TimingReminder timingReminder = timingReminderService.getById(id);
		model.addAttribute("timingReminder", timingReminder);
		return "system/timingReminder/timingReminderEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid TimingReminder timingReminder) {
		return status(timingReminderService.updateById(timingReminder));
	}
}
