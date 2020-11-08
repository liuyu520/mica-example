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

import net.dreamlu.convention.model.House;
import net.dreamlu.convention.service.IHouseService;
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
@RequestMapping("/house")
public class HouseController extends BaseController {

	@Autowired
	private IHouseService houseService;

	@GetMapping("/manager")
	public String manager() {
		return "system/house/houseList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<House> dataGrid(House house, PageVO pageVO) {
		QueryWrapper<House> ew = new QueryWrapper<House>(house);
		Page<House> pages = pageVO.toPage();
		houseService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/house/houseAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid House house) {
		return status(houseService.save(house));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(House house) {
		return status(houseService.removeById(house));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		House house = houseService.getById(id);
		model.addAttribute("house", house);
		return "system/house/houseEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid House house) {
		return status(houseService.updateById(house));
	}
}
