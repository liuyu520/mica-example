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

import net.dreamlu.convention.model.ParamsQueryMappingConfig;
import net.dreamlu.convention.service.IParamsQueryMappingConfigService;
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
@RequestMapping("/paramsQueryMappingConfig")
public class ParamsQueryMappingConfigController extends BaseController {

	@Autowired
	private IParamsQueryMappingConfigService paramsQueryMappingConfigService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('paramsQueryMappingConfig:manager')")
	public String manager() {
		return "system/paramsQueryMappingConfig/paramsQueryMappingConfigList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('paramsQueryMappingConfig:dataGrid')")
	@ResponseBody
	public EasyPage<ParamsQueryMappingConfig> dataGrid(ParamsQueryMappingConfig paramsQueryMappingConfig, PageVO pageVO) {
		QueryWrapper<ParamsQueryMappingConfig> ew = new QueryWrapper<ParamsQueryMappingConfig>(paramsQueryMappingConfig);
		Page<ParamsQueryMappingConfig> pages = pageVO.toPage();
		paramsQueryMappingConfigService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/paramsQueryMappingConfig/paramsQueryMappingConfigAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('paramsQueryMappingConfig:add')")
	@ResponseBody
	public Object add(@Valid ParamsQueryMappingConfig paramsQueryMappingConfig) {
		return status(paramsQueryMappingConfigService.save(paramsQueryMappingConfig));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('paramsQueryMappingConfig:delete')")
	@ResponseBody
	public Object delete(ParamsQueryMappingConfig paramsQueryMappingConfig) {
		return status(paramsQueryMappingConfigService.removeById(paramsQueryMappingConfig));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ParamsQueryMappingConfig paramsQueryMappingConfig = paramsQueryMappingConfigService.getById(id);
		model.addAttribute("paramsQueryMappingConfig", paramsQueryMappingConfig);
		return "system/paramsQueryMappingConfig/paramsQueryMappingConfigEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('paramsQueryMappingConfig:edit')")
	@ResponseBody
	public Object edit(@Valid ParamsQueryMappingConfig paramsQueryMappingConfig) {
		return status(paramsQueryMappingConfigService.updateById(paramsQueryMappingConfig));
	}
}
