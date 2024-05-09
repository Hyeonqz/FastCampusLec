package org.delivery.storeadmin.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	// .html 은 자동으로 붙여줌

	@GetMapping(path = {"", "/main"})
	public ModelAndView main() {
		return new ModelAndView("main");
	}

	@GetMapping("/order")
	public ModelAndView order() {
		return new ModelAndView("order/order");
	}
}
