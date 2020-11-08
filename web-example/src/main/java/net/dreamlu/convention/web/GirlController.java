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

import net.dreamlu.convention.model.Girl;
import net.dreamlu.convention.service.IGirlService;
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
@RequestMapping("/girl")
public class GirlController extends BaseController {

	@Autowired
	private IGirlService girlService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('girl:manager')")
	public String manager() {
		return "system/girl/girlList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('girl:dataGrid')")
	@ResponseBody
	public EasyPage<Girl> dataGrid(Girl girl, PageVO pageVO) {
		QueryWrapper<Girl> ew = new QueryWrapper<Girl>(girl);
		Page<Girl> pages = pageVO.toPage();
		girlService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/girl/girlAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('girl:add')")
	@ResponseBody
	public Object add(@Valid Girl girl) {
		return status(girlService.save(girl));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('girl:delete')")
	@ResponseBody
	public Object delete(Girl girl) {
		return status(girlService.removeById(girl));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Girl girl = girlService.getById(id);
		model.addAttribute("girl", girl);
		return "system/girl/girlEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('girl:edit')")
	@ResponseBody
	public Object edit(@Valid Girl girl) {
		return status(girlService.updateById(girl));
	}
}
