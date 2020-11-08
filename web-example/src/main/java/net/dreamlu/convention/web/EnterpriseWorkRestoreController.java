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

import net.dreamlu.convention.model.EnterpriseWorkRestore;
import net.dreamlu.convention.service.IEnterpriseWorkRestoreService;
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
@RequestMapping("/enterpriseWorkRestore")
public class EnterpriseWorkRestoreController extends BaseController {

	@Autowired
	private IEnterpriseWorkRestoreService enterpriseWorkRestoreService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('enterpriseWorkRestore:manager')")
	public String manager() {
		return "system/enterpriseWorkRestore/enterpriseWorkRestoreList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('enterpriseWorkRestore:dataGrid')")
	@ResponseBody
	public EasyPage<EnterpriseWorkRestore> dataGrid(EnterpriseWorkRestore enterpriseWorkRestore, PageVO pageVO) {
		QueryWrapper<EnterpriseWorkRestore> ew = new QueryWrapper<EnterpriseWorkRestore>(enterpriseWorkRestore);
		Page<EnterpriseWorkRestore> pages = pageVO.toPage();
		enterpriseWorkRestoreService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/enterpriseWorkRestore/enterpriseWorkRestoreAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('enterpriseWorkRestore:add')")
	@ResponseBody
	public Object add(@Valid EnterpriseWorkRestore enterpriseWorkRestore) {
		return status(enterpriseWorkRestoreService.save(enterpriseWorkRestore));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('enterpriseWorkRestore:delete')")
	@ResponseBody
	public Object delete(EnterpriseWorkRestore enterpriseWorkRestore) {
		return status(enterpriseWorkRestoreService.removeById(enterpriseWorkRestore));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		EnterpriseWorkRestore enterpriseWorkRestore = enterpriseWorkRestoreService.getById(id);
		model.addAttribute("enterpriseWorkRestore", enterpriseWorkRestore);
		return "system/enterpriseWorkRestore/enterpriseWorkRestoreEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('enterpriseWorkRestore:edit')")
	@ResponseBody
	public Object edit(@Valid EnterpriseWorkRestore enterpriseWorkRestore) {
		return status(enterpriseWorkRestoreService.updateById(enterpriseWorkRestore));
	}
}
