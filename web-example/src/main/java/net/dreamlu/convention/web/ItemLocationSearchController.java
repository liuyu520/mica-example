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

import net.dreamlu.convention.model.ItemLocationSearch;
import net.dreamlu.convention.service.IItemLocationSearchService;
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
@RequestMapping("/itemLocationSearch")
public class ItemLocationSearchController extends BaseController {

	@Autowired
	private IItemLocationSearchService itemLocationSearchService;

	@GetMapping("/manager")
	public String manager() {
		return "system/itemLocationSearch/itemLocationSearchList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<ItemLocationSearch> dataGrid(ItemLocationSearch itemLocationSearch, PageVO pageVO) {
		QueryWrapper<ItemLocationSearch> ew = new QueryWrapper<ItemLocationSearch>(itemLocationSearch);
		Page<ItemLocationSearch> pages = pageVO.toPage();
		itemLocationSearchService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/itemLocationSearch/itemLocationSearchAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid ItemLocationSearch itemLocationSearch) {
		return status(itemLocationSearchService.save(itemLocationSearch));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(ItemLocationSearch itemLocationSearch) {
		return status(itemLocationSearchService.removeById(itemLocationSearch));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ItemLocationSearch itemLocationSearch = itemLocationSearchService.getById(id);
		model.addAttribute("itemLocationSearch", itemLocationSearch);
		return "system/itemLocationSearch/itemLocationSearchEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid ItemLocationSearch itemLocationSearch) {
		return status(itemLocationSearchService.updateById(itemLocationSearch));
	}
}
