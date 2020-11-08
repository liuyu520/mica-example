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

import net.dreamlu.convention.model.CompressFailedPic;
import net.dreamlu.convention.service.ICompressFailedPicService;
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
@RequestMapping("/compressFailedPic")
public class CompressFailedPicController extends BaseController {

	@Autowired
	private ICompressFailedPicService compressFailedPicService;

	@GetMapping("/manager")
	public String manager() {
		return "system/compressFailedPic/compressFailedPicList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<CompressFailedPic> dataGrid(CompressFailedPic compressFailedPic, PageVO pageVO) {
		QueryWrapper<CompressFailedPic> ew = new QueryWrapper<CompressFailedPic>(compressFailedPic);
		Page<CompressFailedPic> pages = pageVO.toPage();
		compressFailedPicService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/compressFailedPic/compressFailedPicAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid CompressFailedPic compressFailedPic) {
		return status(compressFailedPicService.save(compressFailedPic));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(CompressFailedPic compressFailedPic) {
		return status(compressFailedPicService.removeById(compressFailedPic));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		CompressFailedPic compressFailedPic = compressFailedPicService.getById(id);
		model.addAttribute("compressFailedPic", compressFailedPic);
		return "system/compressFailedPic/compressFailedPicEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid CompressFailedPic compressFailedPic) {
		return status(compressFailedPicService.updateById(compressFailedPic));
	}
}
