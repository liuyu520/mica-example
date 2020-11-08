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

import net.dreamlu.convention.model.User2;
import net.dreamlu.convention.service.IUser2Service;
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
@RequestMapping("/user2")
public class User2Controller extends BaseController {

	@Autowired
	private IUser2Service user2Service;

	@GetMapping("/manager")
	public String manager() {
		return "system/user2/user2List";
	}

	@PostMapping("/dataGrid")
	@ResponseBody
	public EasyPage<User2> dataGrid(User2 user2, PageVO pageVO) {
		QueryWrapper<User2> ew = new QueryWrapper<User2>(user2);
		Page<User2> pages = pageVO.toPage();
		user2Service.page(pages, ew);
		return EasyPage.of(pages);
	}

	/**
	 * 添加页面-
	 */
	@GetMapping("/addPage")
	public String addPage() {
		return "system/user2/user2Add";
	}

	/**
	 * 添加页面-
	 */
	@PostMapping("/add")
	@ResponseBody
	public Object add(@Valid User2 user2) {
		return status(user2Service.save(user2));
	}

	/**
	 * 删除-
	 */
	@PostMapping("/delete")
	@ResponseBody
	public Object delete(User2 user2) {
		return status(user2Service.removeById(user2));
	}

	/**
	 * 编辑-
	 */
	@GetMapping("/editPage")
	public String editPage(Model model, Integer id) {
		User2 user2 = user2Service.getById(id);
		model.addAttribute("user2", user2);
		return "system/user2/user2Edit";
	}

	/**
	 * 编辑-
	 */
	@PostMapping("/edit")
	@ResponseBody
	public Object edit(@Valid User2 user2) {
		return status(user2Service.updateById(user2));
	}
}
