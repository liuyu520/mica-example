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

import net.dreamlu.convention.model.StaffTemperatureRecord;
import net.dreamlu.convention.service.IStaffTemperatureRecordService;
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
@RequestMapping("/staffTemperatureRecord")
public class StaffTemperatureRecordController extends BaseController {

	@Autowired
	private IStaffTemperatureRecordService staffTemperatureRecordService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('staffTemperatureRecord:manager')")
	public String manager() {
		return "system/staffTemperatureRecord/staffTemperatureRecordList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('staffTemperatureRecord:dataGrid')")
	@ResponseBody
	public EasyPage<StaffTemperatureRecord> dataGrid(StaffTemperatureRecord staffTemperatureRecord, PageVO pageVO) {
		QueryWrapper<StaffTemperatureRecord> ew = new QueryWrapper<StaffTemperatureRecord>(staffTemperatureRecord);
		Page<StaffTemperatureRecord> pages = pageVO.toPage();
		staffTemperatureRecordService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/staffTemperatureRecord/staffTemperatureRecordAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('staffTemperatureRecord:add')")
	@ResponseBody
	public Object add(@Valid StaffTemperatureRecord staffTemperatureRecord) {
		return status(staffTemperatureRecordService.save(staffTemperatureRecord));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('staffTemperatureRecord:delete')")
	@ResponseBody
	public Object delete(StaffTemperatureRecord staffTemperatureRecord) {
		return status(staffTemperatureRecordService.removeById(staffTemperatureRecord));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		StaffTemperatureRecord staffTemperatureRecord = staffTemperatureRecordService.getById(id);
		model.addAttribute("staffTemperatureRecord", staffTemperatureRecord);
		return "system/staffTemperatureRecord/staffTemperatureRecordEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('staffTemperatureRecord:edit')")
	@ResponseBody
	public Object edit(@Valid StaffTemperatureRecord staffTemperatureRecord) {
		return status(staffTemperatureRecordService.updateById(staffTemperatureRecord));
	}
}
