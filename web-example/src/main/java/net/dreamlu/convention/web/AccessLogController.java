package net.dreamlu.convention.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.dreamlu.common.base.BaseController;
import net.dreamlu.common.result.EasyPage;
import net.dreamlu.common.result.PageVO;
import net.dreamlu.convention.model.AccessLog;
import net.dreamlu.convention.service.IAccessLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import net.dreamlu.convention.model.AccessLog;
import net.dreamlu.convention.service.IAccessLogService;
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
@RequestMapping("/accessLog")
public class AccessLogController extends BaseController {

	@Autowired
	private IAccessLogService accessLogService;

	@GetMapping("/manager")
	public String manager() {
		return "system/accessLog/accessLogList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<AccessLog> dataGrid(AccessLog accessLog, PageVO pageVO) {
		QueryWrapper<AccessLog> ew = new QueryWrapper<AccessLog>(accessLog);
		Page<AccessLog> pages = pageVO.toPage();
		accessLogService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/accessLog/accessLogAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid AccessLog accessLog) {
		return status(accessLogService.save(accessLog));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(AccessLog accessLog) {
		return status(accessLogService.removeById(accessLog));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		AccessLog accessLog = accessLogService.getById(id);
		model.addAttribute("accessLog", accessLog);
		return "system/accessLog/accessLogEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid AccessLog accessLog) {
		return status(accessLogService.updateById(accessLog));
	}
}
