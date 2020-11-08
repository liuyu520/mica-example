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

import net.dreamlu.convention.model.ContactsPeople;
import net.dreamlu.convention.service.IContactsPeopleService;
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
@RequestMapping("/contactsPeople")
public class ContactsPeopleController extends BaseController {

	@Autowired
	private IContactsPeopleService contactsPeopleService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('contactsPeople:manager')")
	public String manager() {
		return "system/contactsPeople/contactsPeopleList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('contactsPeople:dataGrid')")
	@ResponseBody
	public EasyPage<ContactsPeople> dataGrid(ContactsPeople contactsPeople, PageVO pageVO) {
		QueryWrapper<ContactsPeople> ew = new QueryWrapper<ContactsPeople>(contactsPeople);
		Page<ContactsPeople> pages = pageVO.toPage();
		contactsPeopleService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/contactsPeople/contactsPeopleAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('contactsPeople:add')")
	@ResponseBody
	public Object add(@Valid ContactsPeople contactsPeople) {
		return status(contactsPeopleService.save(contactsPeople));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('contactsPeople:delete')")
	@ResponseBody
	public Object delete(ContactsPeople contactsPeople) {
		return status(contactsPeopleService.removeById(contactsPeople));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		ContactsPeople contactsPeople = contactsPeopleService.getById(id);
		model.addAttribute("contactsPeople", contactsPeople);
		return "system/contactsPeople/contactsPeopleEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('contactsPeople:edit')")
	@ResponseBody
	public Object edit(@Valid ContactsPeople contactsPeople) {
		return status(contactsPeopleService.updateById(contactsPeople));
	}
}
