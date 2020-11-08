package net.dreamlu.convention.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.dreamlu.common.base.BaseController;
import net.dreamlu.common.result.EasyPage;
import net.dreamlu.common.result.PageVO;
import net.dreamlu.convention.model.CommonLargeTable;
import net.dreamlu.convention.service.ICommonLargeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanjun
 * @since 2020-11-07
 */
@Controller
@RequestMapping("/commonLargeTable")
public class CommonLargeTableController extends BaseController {

	@Autowired
	private ICommonLargeTableService commonLargeTableService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('commonLargeTable:manager')")
	public String manager() {
		return "system/commonLargeTable/commonLargeTableList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('commonLargeTable:dataGrid')")
	@ResponseBody
	public EasyPage<CommonLargeTable> dataGrid(CommonLargeTable commonLargeTable, PageVO pageVO) {
		QueryWrapper<CommonLargeTable> ew = new QueryWrapper<CommonLargeTable>(commonLargeTable);
		Page<CommonLargeTable> pages = pageVO.toPage();
		commonLargeTableService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/commonLargeTable/commonLargeTableAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('commonLargeTable:add')")
	@ResponseBody
	public Object add(@Valid CommonLargeTable commonLargeTable) {
		return status(commonLargeTableService.save(commonLargeTable));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('commonLargeTable:delete')")
	@ResponseBody
	public Object delete(CommonLargeTable commonLargeTable) {
		return status(commonLargeTableService.removeById(commonLargeTable));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		CommonLargeTable commonLargeTable = commonLargeTableService.getById(id);
		model.addAttribute("commonLargeTable", commonLargeTable);
		return "system/commonLargeTable/commonLargeTableEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('commonLargeTable:edit')")
	@ResponseBody
	public Object edit(@Valid CommonLargeTable commonLargeTable) {
		return status(commonLargeTableService.updateById(commonLargeTable));
	}
}
