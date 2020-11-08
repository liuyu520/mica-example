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

import net.dreamlu.convention.model.BaiduAddressReverse;
import net.dreamlu.convention.service.IBaiduAddressReverseService;
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
@RequestMapping("/baiduAddressReverse")
public class BaiduAddressReverseController extends BaseController {

	@Autowired
	private IBaiduAddressReverseService baiduAddressReverseService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('baiduAddressReverse:manager')")
	public String manager() {
		return "system/baiduAddressReverse/baiduAddressReverseList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('baiduAddressReverse:dataGrid')")
	@ResponseBody
	public EasyPage<BaiduAddressReverse> dataGrid(BaiduAddressReverse baiduAddressReverse, PageVO pageVO) {
		QueryWrapper<BaiduAddressReverse> ew = new QueryWrapper<BaiduAddressReverse>(baiduAddressReverse);
		Page<BaiduAddressReverse> pages = pageVO.toPage();
		baiduAddressReverseService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/baiduAddressReverse/baiduAddressReverseAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('baiduAddressReverse:add')")
	@ResponseBody
	public Object add(@Valid BaiduAddressReverse baiduAddressReverse) {
		return status(baiduAddressReverseService.save(baiduAddressReverse));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('baiduAddressReverse:delete')")
	@ResponseBody
	public Object delete(BaiduAddressReverse baiduAddressReverse) {
		return status(baiduAddressReverseService.removeById(baiduAddressReverse));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		BaiduAddressReverse baiduAddressReverse = baiduAddressReverseService.getById(id);
		model.addAttribute("baiduAddressReverse", baiduAddressReverse);
		return "system/baiduAddressReverse/baiduAddressReverseEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('baiduAddressReverse:edit')")
	@ResponseBody
	public Object edit(@Valid BaiduAddressReverse baiduAddressReverse) {
		return status(baiduAddressReverseService.updateById(baiduAddressReverse));
	}
}
