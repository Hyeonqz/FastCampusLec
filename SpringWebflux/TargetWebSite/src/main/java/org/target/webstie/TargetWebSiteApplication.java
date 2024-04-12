package org.target.webstie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class TargetWebSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetWebSiteApplication.class, args);
	}

	@GetMapping("/")
	public String idnex() {
		return "index";
	}

}
