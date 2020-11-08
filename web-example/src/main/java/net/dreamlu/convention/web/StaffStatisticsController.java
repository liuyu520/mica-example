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

import net.dreamlu.convention.model.StaffStatistics;
import net.dreamlu.convention.service.IStaffStatisticsService;
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
@RequestMapping("/staffStatistics")
public class StaffStatisticsController extends BaseController {

	@Autowired
	private IStaffStatisticsService staffStatisticsService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('staffStatistics:manager')")
	public String manager() {
		return "system/staffStatistics/staffStatisticsList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('staffStatistics:dataGrid')")
	@ResponseBody
	public EasyPage<StaffStatistics> dataGrid(StaffStatistics staffStatistics, PageVO pageVO) {
		QueryWrapper<StaffStatistics> ew = new QueryWrapper<StaffStatistics>(staffStatistics);
		Page<StaffStatistics> pages = pageVO.toPage();
		staffStatisticsService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/staffStatistics/staffStatisticsAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('staffStatistics:add')")
	@ResponseBody
	public Object add(@Valid StaffStatistics staffStatistics) {
		return status(staffStatisticsService.save(staffStatistics));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('staffStatistics:delete')")
	@ResponseBody
	public Object delete(StaffStatistics staffStatistics) {
		return status(staffStatisticsService.removeById(staffStatistics));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		StaffStatistics staffStatistics = staffStatisticsService.getById(id);
		model.addAttribute("staffStatistics", staffStatistics);
		return "system/staffStatistics/staffStatisticsEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('staffStatistics:edit')")
	@ResponseBody
	public Object edit(@Valid StaffStatistics staffStatistics) {
		return status(staffStatisticsService.updateById(staffStatistics));
	}
}
