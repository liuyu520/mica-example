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

import net.dreamlu.convention.model.WideBusinessTableConfig;
import net.dreamlu.convention.service.IWideBusinessTableConfigService;
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
@RequestMapping("/wideBusinessTableConfig")
public class WideBusinessTableConfigController extends BaseController {

	@Autowired
	private IWideBusinessTableConfigService wideBusinessTableConfigService;

	@GetMapping("/manager")
	public String manager() {
		return "system/wideBusinessTableConfig/wideBusinessTableConfigList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<WideBusinessTableConfig> dataGrid(WideBusinessTableConfig wideBusinessTableConfig, PageVO pageVO) {
		QueryWrapper<WideBusinessTableConfig> ew = new QueryWrapper<WideBusinessTableConfig>(wideBusinessTableConfig);
		Page<WideBusinessTableConfig> pages = pageVO.toPage();
		wideBusinessTableConfigService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/wideBusinessTableConfig/wideBusinessTableConfigAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid WideBusinessTableConfig wideBusinessTableConfig) {
		return status(wideBusinessTableConfigService.save(wideBusinessTableConfig));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(WideBusinessTableConfig wideBusinessTableConfig) {
		return status(wideBusinessTableConfigService.removeById(wideBusinessTableConfig));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		WideBusinessTableConfig wideBusinessTableConfig = wideBusinessTableConfigService.getById(id);
		model.addAttribute("wideBusinessTableConfig", wideBusinessTableConfig);
		return "system/wideBusinessTableConfig/wideBusinessTableConfigEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid WideBusinessTableConfig wideBusinessTableConfig) {
		return status(wideBusinessTableConfigService.updateById(wideBusinessTableConfig));
	}
}
