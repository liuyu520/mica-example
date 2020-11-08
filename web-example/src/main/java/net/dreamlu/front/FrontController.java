package net.dreamlu.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

	@GetMapping("index")
	public String index() {
		return "index";
	}
}
