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

import net.dreamlu.convention.model.ProductBaseInfo;
import net.dreamlu.convention.service.IProductBaseInfoService;
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
@RequestMapping("/productBaseInfo")
public class ProductBaseInfoController extends BaseController {

	@Autowired
	private IProductBaseInfoService productBaseInfoService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('productBaseInfo:manager')")
	public String manager() {
		return "system/productBaseInfo/productBaseInfoList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('productBaseInfo:dataGrid')")
	@ResponseBody
	public EasyPage<ProductBaseInfo> dataGrid(ProductBaseInfo productBaseInfo, PageVO pageVO) {
		QueryWrapper<ProductBaseInfo> ew = new QueryWrapper<ProductBaseInfo>(productBaseInfo);
		Page<ProductBaseInfo> pages = pageVO.toPage();
		productBaseInfoService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/productBaseInfo/productBaseInfoAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('productBaseInfo:add')")
	@ResponseBody
	public Object add(@Valid ProductBaseInfo productBaseInfo) {
		return status(productBaseInfoService.save(productBaseInfo));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('productBaseInfo:delete')")
	@ResponseBody
	public Object delete(ProductBaseInfo productBaseInfo) {
		return status(productBaseInfoService.removeById(productBaseInfo));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ProductBaseInfo productBaseInfo = productBaseInfoService.getById(id);
		model.addAttribute("productBaseInfo", productBaseInfo);
		return "system/productBaseInfo/productBaseInfoEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('productBaseInfo:edit')")
	@ResponseBody
	public Object edit(@Valid ProductBaseInfo productBaseInfo) {
		return status(productBaseInfoService.updateById(productBaseInfo));
	}
}
