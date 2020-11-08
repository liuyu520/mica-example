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

import net.dreamlu.convention.model.ServletSessionAttribute;
import net.dreamlu.convention.service.IServletSessionAttributeService;
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
@RequestMapping("/servletSessionAttribute")
public class ServletSessionAttributeController extends BaseController {

	@Autowired
	private IServletSessionAttributeService servletSessionAttributeService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('servletSessionAttribute:manager')")
	public String manager() {
		return "system/servletSessionAttribute/servletSessionAttributeList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('servletSessionAttribute:dataGrid')")
	@ResponseBody
	public EasyPage<ServletSessionAttribute> dataGrid(ServletSessionAttribute servletSessionAttribute, PageVO pageVO) {
		QueryWrapper<ServletSessionAttribute> ew = new QueryWrapper<ServletSessionAttribute>(servletSessionAttribute);
		Page<ServletSessionAttribute> pages = pageVO.toPage();
		servletSessionAttributeService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/servletSessionAttribute/servletSessionAttributeAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('servletSessionAttribute:add')")
	@ResponseBody
	public Object add(@Valid ServletSessionAttribute servletSessionAttribute) {
		return status(servletSessionAttributeService.save(servletSessionAttribute));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('servletSessionAttribute:delete')")
	@ResponseBody
	public Object delete(ServletSessionAttribute servletSessionAttribute) {
		return status(servletSessionAttributeService.removeById(servletSessionAttribute));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ServletSessionAttribute servletSessionAttribute = servletSessionAttributeService.getById(id);
		model.addAttribute("servletSessionAttribute", servletSessionAttribute);
		return "system/servletSessionAttribute/servletSessionAttributeEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('servletSessionAttribute:edit')")
	@ResponseBody
	public Object edit(@Valid ServletSessionAttribute servletSessionAttribute) {
		return status(servletSessionAttributeService.updateById(servletSessionAttribute));
	}
}
