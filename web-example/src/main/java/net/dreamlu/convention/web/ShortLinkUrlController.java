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

import net.dreamlu.convention.model.ShortLinkUrl;
import net.dreamlu.convention.service.IShortLinkUrlService;
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
@RequestMapping("/shortLinkUrl")
public class ShortLinkUrlController extends BaseController {

	@Autowired
	private IShortLinkUrlService shortLinkUrlService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('shortLinkUrl:manager')")
	public String manager() {
		return "system/shortLinkUrl/shortLinkUrlList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('shortLinkUrl:dataGrid')")
	@ResponseBody
	public EasyPage<ShortLinkUrl> dataGrid(ShortLinkUrl shortLinkUrl, PageVO pageVO) {
		QueryWrapper<ShortLinkUrl> ew = new QueryWrapper<ShortLinkUrl>(shortLinkUrl);
		Page<ShortLinkUrl> pages = pageVO.toPage();
		shortLinkUrlService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/shortLinkUrl/shortLinkUrlAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('shortLinkUrl:add')")
	@ResponseBody
	public Object add(@Valid ShortLinkUrl shortLinkUrl) {
		return status(shortLinkUrlService.save(shortLinkUrl));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('shortLinkUrl:delete')")
	@ResponseBody
	public Object delete(ShortLinkUrl shortLinkUrl) {
		return status(shortLinkUrlService.removeById(shortLinkUrl));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ShortLinkUrl shortLinkUrl = shortLinkUrlService.getById(id);
		model.addAttribute("shortLinkUrl", shortLinkUrl);
		return "system/shortLinkUrl/shortLinkUrlEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('shortLinkUrl:edit')")
	@ResponseBody
	public Object edit(@Valid ShortLinkUrl shortLinkUrl) {
		return status(shortLinkUrlService.updateById(shortLinkUrl));
	}
}
