package org.example.mvc;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MvcApplication {

	public static void main (String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	// id 를 받아서 임의로 return 값을 주는 로직
	@GetMapping("/posts/{id}")
	public Map<String,String> getPosts(@PathVariable Long id) throws Exception {
		Thread.sleep(300);

		if (id > 10L) {
			throw new Exception("Too long");
		}

		return Map.of("id",id.toString(), "content", "Post content is %d".formatted(id));
	}


}
