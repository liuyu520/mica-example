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

import net.dreamlu.convention.model.TemperatureTntermediateTable;
import net.dreamlu.convention.service.ITemperatureTntermediateTableService;
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
@RequestMapping("/temperatureTntermediateTable")
public class TemperatureTntermediateTableController extends BaseController {

	@Autowired
	private ITemperatureTntermediateTableService temperatureTntermediateTableService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('temperatureTntermediateTable:manager')")
	public String manager() {
		return "system/temperatureTntermediateTable/temperatureTntermediateTableList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('temperatureTntermediateTable:dataGrid')")
	@ResponseBody
	public EasyPage<TemperatureTntermediateTable> dataGrid(TemperatureTntermediateTable temperatureTntermediateTable, PageVO pageVO) {
		QueryWrapper<TemperatureTntermediateTable> ew = new QueryWrapper<TemperatureTntermediateTable>(temperatureTntermediateTable);
		Page<TemperatureTntermediateTable> pages = pageVO.toPage();
		temperatureTntermediateTableService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/temperatureTntermediateTable/temperatureTntermediateTableAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('temperatureTntermediateTable:add')")
	@ResponseBody
	public Object add(@Valid TemperatureTntermediateTable temperatureTntermediateTable) {
		return status(temperatureTntermediateTableService.save(temperatureTntermediateTable));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('temperatureTntermediateTable:delete')")
	@ResponseBody
	public Object delete(TemperatureTntermediateTable temperatureTntermediateTable) {
		return status(temperatureTntermediateTableService.removeById(temperatureTntermediateTable));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		TemperatureTntermediateTable temperatureTntermediateTable = temperatureTntermediateTableService.getById(id);
		model.addAttribute("temperatureTntermediateTable", temperatureTntermediateTable);
		return "system/temperatureTntermediateTable/temperatureTntermediateTableEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('temperatureTntermediateTable:edit')")
	@ResponseBody
	public Object edit(@Valid TemperatureTntermediateTable temperatureTntermediateTable) {
		return status(temperatureTntermediateTableService.updateById(temperatureTntermediateTable));
	}
}
