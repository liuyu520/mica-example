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

import net.dreamlu.convention.model.MemoryCurveLawRemind;
import net.dreamlu.convention.service.IMemoryCurveLawRemindService;
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
@RequestMapping("/memoryCurveLawRemind")
public class MemoryCurveLawRemindController extends BaseController {

	@Autowired
	private IMemoryCurveLawRemindService memoryCurveLawRemindService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('memoryCurveLawRemind:manager')")
	public String manager() {
		return "system/memoryCurveLawRemind/memoryCurveLawRemindList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('memoryCurveLawRemind:dataGrid')")
	@ResponseBody
	public EasyPage<MemoryCurveLawRemind> dataGrid(MemoryCurveLawRemind memoryCurveLawRemind, PageVO pageVO) {
		QueryWrapper<MemoryCurveLawRemind> ew = new QueryWrapper<MemoryCurveLawRemind>(memoryCurveLawRemind);
		Page<MemoryCurveLawRemind> pages = pageVO.toPage();
		memoryCurveLawRemindService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/memoryCurveLawRemind/memoryCurveLawRemindAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('memoryCurveLawRemind:add')")
	@ResponseBody
	public Object add(@Valid MemoryCurveLawRemind memoryCurveLawRemind) {
		return status(memoryCurveLawRemindService.save(memoryCurveLawRemind));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('memoryCurveLawRemind:delete')")
	@ResponseBody
	public Object delete(MemoryCurveLawRemind memoryCurveLawRemind) {
		return status(memoryCurveLawRemindService.removeById(memoryCurveLawRemind));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		MemoryCurveLawRemind memoryCurveLawRemind = memoryCurveLawRemindService.getById(id);
		model.addAttribute("memoryCurveLawRemind", memoryCurveLawRemind);
		return "system/memoryCurveLawRemind/memoryCurveLawRemindEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('memoryCurveLawRemind:edit')")
	@ResponseBody
	public Object edit(@Valid MemoryCurveLawRemind memoryCurveLawRemind) {
		return status(memoryCurveLawRemindService.updateById(memoryCurveLawRemind));
	}
}
