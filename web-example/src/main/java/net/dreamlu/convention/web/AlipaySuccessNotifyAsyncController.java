package net.dreamlu.convention.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.dreamlu.common.base.BaseController;
import net.dreamlu.common.result.EasyPage;
import net.dreamlu.common.result.PageVO;
import net.dreamlu.convention.model.AlipaySuccessNotifyAsync;
import net.dreamlu.convention.service.IAlipaySuccessNotifyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanjun
 * @since 2020-11-07
 */
@Controller
@RequestMapping("/alipaySuccessNotifyAsync")
public class AlipaySuccessNotifyAsyncController extends BaseController {

	@Autowired
	private IAlipaySuccessNotifyAsyncService alipaySuccessNotifyAsyncService;

	@GetMapping("/manager")
	public String manager() {
		return "system/alipaySuccessNotifyAsync/alipaySuccessNotifyAsyncList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<AlipaySuccessNotifyAsync> dataGrid(AlipaySuccessNotifyAsync alipaySuccessNotifyAsync, PageVO pageVO) {
		QueryWrapper<AlipaySuccessNotifyAsync> ew = new QueryWrapper<AlipaySuccessNotifyAsync>(alipaySuccessNotifyAsync);
		Page<AlipaySuccessNotifyAsync> pages = pageVO.toPage();
		alipaySuccessNotifyAsyncService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/alipaySuccessNotifyAsync/alipaySuccessNotifyAsyncAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid AlipaySuccessNotifyAsync alipaySuccessNotifyAsync) {
		return status(alipaySuccessNotifyAsyncService.save(alipaySuccessNotifyAsync));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(AlipaySuccessNotifyAsync alipaySuccessNotifyAsync) {
		return status(alipaySuccessNotifyAsyncService.removeById(alipaySuccessNotifyAsync));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		AlipaySuccessNotifyAsync alipaySuccessNotifyAsync = alipaySuccessNotifyAsyncService.getById(id);
		model.addAttribute("alipaySuccessNotifyAsync", alipaySuccessNotifyAsync);
		return "system/alipaySuccessNotifyAsync/alipaySuccessNotifyAsyncEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid AlipaySuccessNotifyAsync alipaySuccessNotifyAsync) {
		return status(alipaySuccessNotifyAsyncService.updateById(alipaySuccessNotifyAsync));
	}
}