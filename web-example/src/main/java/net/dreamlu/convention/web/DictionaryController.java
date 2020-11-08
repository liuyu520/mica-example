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

import net.dreamlu.convention.model.Dictionary;
import net.dreamlu.convention.service.IDictionaryService;
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
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {

	@Autowired
	private IDictionaryService dictionaryService;

	@GetMapping("/manager")
	@PreAuthorize("@sec.hasPermission('dictionary:manager')")
	public String manager() {
		return "system/dictionary/dictionaryList";
	}

	@PostMapping("/dataGrid")
	@PreAuthorize("@sec.hasPermission('dictionary:dataGrid')")
	@ResponseBody
	public EasyPage<Dictionary> dataGrid(Dictionary dictionary, PageVO pageVO) {
		QueryWrapper<Dictionary> ew = new QueryWrapper<Dictionary>(dictionary);
		Page<Dictionary> pages = pageVO.toPage();
		dictionaryService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/dictionary/dictionaryAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@PreAuthorize("@sec.hasPermission('dictionary:add')")
	@ResponseBody
	public Object add(@Valid Dictionary dictionary) {
		return status(dictionaryService.save(dictionary));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@PreAuthorize("@sec.hasPermission('dictionary:delete')")
	@ResponseBody
	public Object delete(Dictionary dictionary) {
		return status(dictionaryService.removeById(dictionary));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		Dictionary dictionary = dictionaryService.getById(id);
		model.addAttribute("dictionary", dictionary);
		return "system/dictionary/dictionaryEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@PreAuthorize("@sec.hasPermission('dictionary:edit')")
	@ResponseBody
	public Object edit(@Valid Dictionary dictionary) {
		return status(dictionaryService.updateById(dictionary));
	}
}
