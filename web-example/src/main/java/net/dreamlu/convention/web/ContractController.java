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

import net.dreamlu.convention.model.Contract;
import net.dreamlu.convention.service.IContractService;
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
@RequestMapping("/contract")
public class ContractController extends BaseController {

	@Autowired
	private IContractService contractService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('contract:manager')")
	public String manager() {
		return "system/contract/contractList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('contract:dataGrid')")
	@ResponseBody
	public EasyPage<Contract> dataGrid(Contract contract, PageVO pageVO) {
		QueryWrapper<Contract> ew = new QueryWrapper<Contract>(contract);
		Page<Contract> pages = pageVO.toPage();
		contractService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/contract/contractAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('contract:add')")
	@ResponseBody
	public Object add(@Valid Contract contract) {
		return status(contractService.save(contract));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('contract:delete')")
	@ResponseBody
	public Object delete(Contract contract) {
		return status(contractService.removeById(contract));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Contract contract = contractService.getById(id);
		model.addAttribute("contract", contract);
		return "system/contract/contractEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('contract:edit')")
	@ResponseBody
	public Object edit(@Valid Contract contract) {
		return status(contractService.updateById(contract));
	}
}
