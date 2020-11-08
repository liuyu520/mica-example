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

import net.dreamlu.convention.model.IntoStaffStatistics;
import net.dreamlu.convention.service.IIntoStaffStatisticsService;
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
@RequestMapping("/intoStaffStatistics")
public class IntoStaffStatisticsController extends BaseController {

	@Autowired
	private IIntoStaffStatisticsService intoStaffStatisticsService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('intoStaffStatistics:manager')")
	public String manager() {
		return "system/intoStaffStatistics/intoStaffStatisticsList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('intoStaffStatistics:dataGrid')")
	@ResponseBody
	public EasyPage<IntoStaffStatistics> dataGrid(IntoStaffStatistics intoStaffStatistics, PageVO pageVO) {
		QueryWrapper<IntoStaffStatistics> ew = new QueryWrapper<IntoStaffStatistics>(intoStaffStatistics);
		Page<IntoStaffStatistics> pages = pageVO.toPage();
		intoStaffStatisticsService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/intoStaffStatistics/intoStaffStatisticsAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('intoStaffStatistics:add')")
	@ResponseBody
	public Object add(@Valid IntoStaffStatistics intoStaffStatistics) {
		return status(intoStaffStatisticsService.save(intoStaffStatistics));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('intoStaffStatistics:delete')")
	@ResponseBody
	public Object delete(IntoStaffStatistics intoStaffStatistics) {
		return status(intoStaffStatisticsService.removeById(intoStaffStatistics));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		IntoStaffStatistics intoStaffStatistics = intoStaffStatisticsService.getById(id);
		model.addAttribute("intoStaffStatistics", intoStaffStatistics);
		return "system/intoStaffStatistics/intoStaffStatisticsEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('intoStaffStatistics:edit')")
	@ResponseBody
	public Object edit(@Valid IntoStaffStatistics intoStaffStatistics) {
		return status(intoStaffStatisticsService.updateById(intoStaffStatistics));
	}
}
