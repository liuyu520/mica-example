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

import net.dreamlu.convention.model.VoteLog;
import net.dreamlu.convention.service.IVoteLogService;
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
@RequestMapping("/voteLog")
public class VoteLogController extends BaseController {

	@Autowired
	private IVoteLogService voteLogService;

	@GetMapping("/manager")
	public String manager() {
		return "system/voteLog/voteLogList";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<VoteLog> dataGrid(VoteLog voteLog, PageVO pageVO) {
		QueryWrapper<VoteLog> ew = new QueryWrapper<VoteLog>(voteLog);
		Page<VoteLog> pages = pageVO.toPage();
		voteLogService.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/voteLog/voteLogAdd";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid VoteLog voteLog) {
		return status(voteLogService.save(voteLog));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(VoteLog voteLog) {
		return status(voteLogService.removeById(voteLog));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		VoteLog voteLog = voteLogService.getById(id);
		model.addAttribute("voteLog", voteLog);
		return "system/voteLog/voteLogEdit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid VoteLog voteLog) {
		return status(voteLogService.updateById(voteLog));
	}
}
