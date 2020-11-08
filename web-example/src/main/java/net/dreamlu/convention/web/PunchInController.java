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

import net.dreamlu.convention.model.PunchIn;
import net.dreamlu.convention.service.IPunchInService;
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
@RequestMapping("/punchIn")
public class PunchInController extends BaseController {

	@Autowired
	private IPunchInService punchInService;

	@GetMapping("/manager")
	public String manager() {
		return "system/punchIn/punchInList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<PunchIn> dataGrid(PunchIn punchIn, PageVO pageVO) {
		QueryWrapper<PunchIn> ew = new QueryWrapper<PunchIn>(punchIn);
		Page<PunchIn> pages = pageVO.toPage();
		punchInService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/punchIn/punchInAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid PunchIn punchIn) {
		return status(punchInService.save(punchIn));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(PunchIn punchIn) {
		return status(punchInService.removeById(punchIn));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		PunchIn punchIn = punchInService.getById(id);
		model.addAttribute("punchIn", punchIn);
		return "system/punchIn/punchInEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid PunchIn punchIn) {
		return status(punchInService.updateById(punchIn));
	}
}
