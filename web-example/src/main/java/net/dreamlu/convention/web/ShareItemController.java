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

import net.dreamlu.convention.model.ShareItem;
import net.dreamlu.convention.service.IShareItemService;
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
@RequestMapping("/shareItem")
public class ShareItemController extends BaseController {

	@Autowired
	private IShareItemService shareItemService;

	@GetMapping("/manager")
	public String manager() {
		return "system/shareItem/shareItemList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<ShareItem> dataGrid(ShareItem shareItem, PageVO pageVO) {
		QueryWrapper<ShareItem> ew = new QueryWrapper<ShareItem>(shareItem);
		Page<ShareItem> pages = pageVO.toPage();
		shareItemService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/shareItem/shareItemAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid ShareItem shareItem) {
		return status(shareItemService.save(shareItem));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(ShareItem shareItem) {
		return status(shareItemService.removeById(shareItem));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ShareItem shareItem = shareItemService.getById(id);
		model.addAttribute("shareItem", shareItem);
		return "system/shareItem/shareItemEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid ShareItem shareItem) {
		return status(shareItemService.updateById(shareItem));
	}
}
