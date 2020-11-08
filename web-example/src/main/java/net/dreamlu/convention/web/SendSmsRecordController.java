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

import net.dreamlu.convention.model.SendSmsRecord;
import net.dreamlu.convention.service.ISendSmsRecordService;
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
@RequestMapping("/sendSmsRecord")
public class SendSmsRecordController extends BaseController {

	@Autowired
	private ISendSmsRecordService sendSmsRecordService;

	@GetMapping("/manager")
	public String manager() {
		return "system/sendSmsRecord/sendSmsRecordList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<SendSmsRecord> dataGrid(SendSmsRecord sendSmsRecord, PageVO pageVO) {
		QueryWrapper<SendSmsRecord> ew = new QueryWrapper<SendSmsRecord>(sendSmsRecord);
		Page<SendSmsRecord> pages = pageVO.toPage();
		sendSmsRecordService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/sendSmsRecord/sendSmsRecordAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid SendSmsRecord sendSmsRecord) {
		return status(sendSmsRecordService.save(sendSmsRecord));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(SendSmsRecord sendSmsRecord) {
		return status(sendSmsRecordService.removeById(sendSmsRecord));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		SendSmsRecord sendSmsRecord = sendSmsRecordService.getById(id);
		model.addAttribute("sendSmsRecord", sendSmsRecord);
		return "system/sendSmsRecord/sendSmsRecordEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid SendSmsRecord sendSmsRecord) {
		return status(sendSmsRecordService.updateById(sendSmsRecord));
	}
}
