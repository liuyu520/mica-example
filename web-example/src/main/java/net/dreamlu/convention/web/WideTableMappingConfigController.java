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

import net.dreamlu.convention.model.WideTableMappingConfig;
import net.dreamlu.convention.service.IWideTableMappingConfigService;
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
@RequestMapping("/wideTableMappingConfig")
public class WideTableMappingConfigController extends BaseController {

	@Autowired
	private IWideTableMappingConfigService wideTableMappingConfigService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('wideTableMappingConfig:manager')")
	public String manager() {
		return "system/wideTableMappingConfig/wideTableMappingConfigList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('wideTableMappingConfig:dataGrid')")
	@ResponseBody
	public EasyPage<WideTableMappingConfig> dataGrid(WideTableMappingConfig wideTableMappingConfig, PageVO pageVO) {
		QueryWrapper<WideTableMappingConfig> ew = new QueryWrapper<WideTableMappingConfig>(wideTableMappingConfig);
		Page<WideTableMappingConfig> pages = pageVO.toPage();
		wideTableMappingConfigService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/wideTableMappingConfig/wideTableMappingConfigAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('wideTableMappingConfig:add')")
	@ResponseBody
	public Object add(@Valid WideTableMappingConfig wideTableMappingConfig) {
		return status(wideTableMappingConfigService.save(wideTableMappingConfig));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('wideTableMappingConfig:delete')")
	@ResponseBody
	public Object delete(WideTableMappingConfig wideTableMappingConfig) {
		return status(wideTableMappingConfigService.removeById(wideTableMappingConfig));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		WideTableMappingConfig wideTableMappingConfig = wideTableMappingConfigService.getById(id);
		model.addAttribute("wideTableMappingConfig", wideTableMappingConfig);
		return "system/wideTableMappingConfig/wideTableMappingConfigEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('wideTableMappingConfig:edit')")
	@ResponseBody
	public Object edit(@Valid WideTableMappingConfig wideTableMappingConfig) {
		return status(wideTableMappingConfigService.updateById(wideTableMappingConfig));
	}
}
