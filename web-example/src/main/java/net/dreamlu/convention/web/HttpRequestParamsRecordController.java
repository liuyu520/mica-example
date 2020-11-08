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

import net.dreamlu.convention.model.HttpRequestParamsRecord;
import net.dreamlu.convention.service.IHttpRequestParamsRecordService;
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
@RequestMapping("/httpRequestParamsRecord")
public class HttpRequestParamsRecordController extends BaseController {

	@Autowired
	private IHttpRequestParamsRecordService httpRequestParamsRecordService;

	@GetMapping("/manager")
	public String manager() {
		return "system/httpRequestParamsRecord/httpRequestParamsRecordList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<HttpRequestParamsRecord> dataGrid(HttpRequestParamsRecord httpRequestParamsRecord, PageVO pageVO) {
		QueryWrapper<HttpRequestParamsRecord> ew = new QueryWrapper<HttpRequestParamsRecord>(httpRequestParamsRecord);
		Page<HttpRequestParamsRecord> pages = pageVO.toPage();
		httpRequestParamsRecordService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/httpRequestParamsRecord/httpRequestParamsRecordAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid HttpRequestParamsRecord httpRequestParamsRecord) {
		return status(httpRequestParamsRecordService.save(httpRequestParamsRecord));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(HttpRequestParamsRecord httpRequestParamsRecord) {
		return status(httpRequestParamsRecordService.removeById(httpRequestParamsRecord));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		HttpRequestParamsRecord httpRequestParamsRecord = httpRequestParamsRecordService.getById(id);
		model.addAttribute("httpRequestParamsRecord", httpRequestParamsRecord);
		return "system/httpRequestParamsRecord/httpRequestParamsRecordEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid HttpRequestParamsRecord httpRequestParamsRecord) {
		return status(httpRequestParamsRecordService.updateById(httpRequestParamsRecord));
	}
}
