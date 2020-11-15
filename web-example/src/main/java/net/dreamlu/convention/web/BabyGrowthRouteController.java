package net.dreamlu.convention.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.dreamlu.common.base.BaseController;
import net.dreamlu.common.result.EasyPage;
import net.dreamlu.common.result.PageVO;
import net.dreamlu.convention.model.BabyGrowthRoute;
import net.dreamlu.convention.service.IBabyGrowthRouteService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2020-11-15
 */
@Controller
@RequestMapping("/babyGrowthRoute")
public class BabyGrowthRouteController extends BaseController {

	@Autowired
	private IBabyGrowthRouteService babyGrowthRouteService;

	@GetMapping("/manager")
	public String manager() {
		return "system/babyGrowthRoute/babyGrowthRouteList";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public EasyPage<BabyGrowthRoute> dataGrid(BabyGrowthRoute babyGrowthRoute, PageVO pageVO) {
		QueryWrapper<BabyGrowthRoute> ew = new QueryWrapper<BabyGrowthRoute>(babyGrowthRoute);
		Page<BabyGrowthRoute> pages = pageVO.toPage();
		babyGrowthRouteService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/babyGrowthRoute/babyGrowthRouteAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid BabyGrowthRoute babyGrowthRoute) {
		return status(babyGrowthRouteService.save(babyGrowthRoute));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
//    @PreAuthorize("@sec.hasPermission('babyGrowthRoute:delete')")
	@ResponseBody
	public Object delete(BabyGrowthRoute babyGrowthRoute) {
		return status(babyGrowthRouteService.removeById(babyGrowthRoute));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		BabyGrowthRoute babyGrowthRoute = babyGrowthRouteService.getById(id);
		model.addAttribute("babyGrowthRoute", babyGrowthRoute);
		return "system/babyGrowthRoute/babyGrowthRouteEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
//    @PreAuthorize("@sec.hasPermission('babyGrowthRoute:edit')")
	@ResponseBody
	public Object edit(@Valid BabyGrowthRoute babyGrowthRoute) {
		return status(babyGrowthRouteService.updateById(babyGrowthRoute));
	}
}
