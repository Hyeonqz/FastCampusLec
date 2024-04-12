package org.example.mvc;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@SpringBootApplication
public class MvcApplication {

	private final RedisTemplate<String, String> redisTemplate;

	public static void main (String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	@GetMapping("/health")
	public Map<String, String> health() {
		return Map.of("health","ok");
	}

	@GetMapping("/users/1/cache")
	public Map<String, String> getCachedUser() {
		var name = redisTemplate.opsForValue().get("users:1:name");
		var email = redisTemplate.opsForValue().get("users:1:email");
		return Map.of("name", name==null ? "" : name, "email", email == null ? "" : email);
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

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name= "users")
class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}

