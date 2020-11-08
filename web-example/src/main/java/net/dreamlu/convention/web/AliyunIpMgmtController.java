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

import net.dreamlu.convention.model.AliyunIpMgmt;
import net.dreamlu.convention.service.IAliyunIpMgmtService;
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
@RequestMapping("/aliyunIpMgmt")
public class AliyunIpMgmtController extends BaseController {

	@Autowired
	private IAliyunIpMgmtService aliyunIpMgmtService;

	@GetMapping("/manager")
	public String manager() {
		return "system/aliyunIpMgmt/aliyunIpMgmtList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<AliyunIpMgmt> dataGrid(AliyunIpMgmt aliyunIpMgmt, PageVO pageVO) {
		QueryWrapper<AliyunIpMgmt> ew = new QueryWrapper<AliyunIpMgmt>(aliyunIpMgmt);
		Page<AliyunIpMgmt> pages = pageVO.toPage();
		aliyunIpMgmtService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/aliyunIpMgmt/aliyunIpMgmtAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid AliyunIpMgmt aliyunIpMgmt) {
		return status(aliyunIpMgmtService.save(aliyunIpMgmt));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(AliyunIpMgmt aliyunIpMgmt) {
		return status(aliyunIpMgmtService.removeById(aliyunIpMgmt));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		AliyunIpMgmt aliyunIpMgmt = aliyunIpMgmtService.getById(id);
		model.addAttribute("aliyunIpMgmt", aliyunIpMgmt);
		return "system/aliyunIpMgmt/aliyunIpMgmtEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid AliyunIpMgmt aliyunIpMgmt) {
		return status(aliyunIpMgmtService.updateById(aliyunIpMgmt));
	}
}
