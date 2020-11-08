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

import net.dreamlu.convention.model.ThoughtPattern;
import net.dreamlu.convention.service.IThoughtPatternService;
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
@RequestMapping("/thoughtPattern")
public class ThoughtPatternController extends BaseController {

	@Autowired
	private IThoughtPatternService thoughtPatternService;

	@GetMapping("/manager")
	public String manager() {
		return "system/thoughtPattern/thoughtPatternList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<ThoughtPattern> dataGrid(ThoughtPattern thoughtPattern, PageVO pageVO) {
		QueryWrapper<ThoughtPattern> ew = new QueryWrapper<ThoughtPattern>(thoughtPattern);
		Page<ThoughtPattern> pages = pageVO.toPage();
		thoughtPatternService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/thoughtPattern/thoughtPatternAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid ThoughtPattern thoughtPattern) {
		return status(thoughtPatternService.save(thoughtPattern));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(ThoughtPattern thoughtPattern) {
		return status(thoughtPatternService.removeById(thoughtPattern));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ThoughtPattern thoughtPattern = thoughtPatternService.getById(id);
		model.addAttribute("thoughtPattern", thoughtPattern);
		return "system/thoughtPattern/thoughtPatternEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid ThoughtPattern thoughtPattern) {
		return status(thoughtPatternService.updateById(thoughtPattern));
	}
}
