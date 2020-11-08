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

import net.dreamlu.convention.model.Diary;
import net.dreamlu.convention.service.IDiaryService;
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
@RequestMapping("/diary")
public class DiaryController extends BaseController {

	@Autowired
	private IDiaryService diaryService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('diary:manager')")
	public String manager() {
		return "system/diary/diaryList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('diary:dataGrid')")
	@ResponseBody
	public EasyPage<Diary> dataGrid(Diary diary, PageVO pageVO) {
		QueryWrapper<Diary> ew = new QueryWrapper<Diary>(diary);
		Page<Diary> pages = pageVO.toPage();
		diaryService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/diary/diaryAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('diary:add')")
	@ResponseBody
	public Object add(@Valid Diary diary) {
		return status(diaryService.save(diary));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('diary:delete')")
	@ResponseBody
	public Object delete(Diary diary) {
		return status(diaryService.removeById(diary));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Diary diary = diaryService.getById(id);
		model.addAttribute("diary", diary);
		return "system/diary/diaryEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('diary:edit')")
	@ResponseBody
	public Object edit(@Valid Diary diary) {
		return status(diaryService.updateById(diary));
	}
}
