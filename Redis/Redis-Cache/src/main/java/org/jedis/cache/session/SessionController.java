package org.jedis.cache.session;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {

	@GetMapping("/")
	public Map<String,String> home(HttpSession httpSession) {
		Integer visitCount = (Integer)httpSession.getAttribute("visitis");

		if(visitCount == null) {
			visitCount = 0;
		}
		httpSession.setAttribute("visits", ++visitCount);
		return Map.of("session id", httpSession.getId(), "visits",visitCount.toString());
	}
}
