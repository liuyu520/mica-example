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

import net.dreamlu.convention.model.BabyRecord;
import net.dreamlu.convention.service.IBabyRecordService;
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
@RequestMapping("/babyRecord")
public class BabyRecordController extends BaseController {

	@Autowired
	private IBabyRecordService babyRecordService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('babyRecord:manager')")
	public String manager() {
		return "system/babyRecord/babyRecordList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('babyRecord:dataGrid')")
	@ResponseBody
	public EasyPage<BabyRecord> dataGrid(BabyRecord babyRecord, PageVO pageVO) {
		QueryWrapper<BabyRecord> ew = new QueryWrapper<BabyRecord>(babyRecord);
		Page<BabyRecord> pages = pageVO.toPage();
		babyRecordService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/babyRecord/babyRecordAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('babyRecord:add')")
	@ResponseBody
	public Object add(@Valid BabyRecord babyRecord) {
		return status(babyRecordService.save(babyRecord));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('babyRecord:delete')")
	@ResponseBody
	public Object delete(BabyRecord babyRecord) {
		return status(babyRecordService.removeById(babyRecord));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		BabyRecord babyRecord = babyRecordService.getById(id);
		model.addAttribute("babyRecord", babyRecord);
		return "system/babyRecord/babyRecordEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('babyRecord:edit')")
	@ResponseBody
	public Object edit(@Valid BabyRecord babyRecord) {
		return status(babyRecordService.updateById(babyRecord));
	}
}
