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

import net.dreamlu.convention.model.SimpleInfo;
import net.dreamlu.convention.service.ISimpleInfoService;
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
@RequestMapping("/simpleInfo")
public class SimpleInfoController extends BaseController {

	@Autowired
	private ISimpleInfoService simpleInfoService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('simpleInfo:manager')")
	public String manager() {
		return "system/simpleInfo/simpleInfoList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('simpleInfo:dataGrid')")
	@ResponseBody
	public EasyPage<SimpleInfo> dataGrid(SimpleInfo simpleInfo, PageVO pageVO) {
		QueryWrapper<SimpleInfo> ew = new QueryWrapper<SimpleInfo>(simpleInfo);
		Page<SimpleInfo> pages = pageVO.toPage();
		simpleInfoService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/simpleInfo/simpleInfoAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('simpleInfo:add')")
	@ResponseBody
	public Object add(@Valid SimpleInfo simpleInfo) {
		return status(simpleInfoService.save(simpleInfo));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('simpleInfo:delete')")
	@ResponseBody
	public Object delete(SimpleInfo simpleInfo) {
		return status(simpleInfoService.removeById(simpleInfo));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		SimpleInfo simpleInfo = simpleInfoService.getById(id);
		model.addAttribute("simpleInfo", simpleInfo);
		return "system/simpleInfo/simpleInfoEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('simpleInfo:edit')")
	@ResponseBody
	public Object edit(@Valid SimpleInfo simpleInfo) {
		return status(simpleInfoService.updateById(simpleInfo));
	}
}
