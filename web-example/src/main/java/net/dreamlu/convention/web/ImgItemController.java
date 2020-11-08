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

import net.dreamlu.convention.model.ImgItem;
import net.dreamlu.convention.service.IImgItemService;
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
@RequestMapping("/imgItem")
public class ImgItemController extends BaseController {

	@Autowired
	private IImgItemService imgItemService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('imgItem:manager')")
	public String manager() {
		return "system/imgItem/imgItemList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('imgItem:dataGrid')")
	@ResponseBody
	public EasyPage<ImgItem> dataGrid(ImgItem imgItem, PageVO pageVO) {
		QueryWrapper<ImgItem> ew = new QueryWrapper<ImgItem>(imgItem);
		Page<ImgItem> pages = pageVO.toPage();
		imgItemService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/imgItem/imgItemAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('imgItem:add')")
	@ResponseBody
	public Object add(@Valid ImgItem imgItem) {
		return status(imgItemService.save(imgItem));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('imgItem:delete')")
	@ResponseBody
	public Object delete(ImgItem imgItem) {
		return status(imgItemService.removeById(imgItem));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ImgItem imgItem = imgItemService.getById(id);
		model.addAttribute("imgItem", imgItem);
		return "system/imgItem/imgItemEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('imgItem:edit')")
	@ResponseBody
	public Object edit(@Valid ImgItem imgItem) {
		return status(imgItemService.updateById(imgItem));
	}
}
