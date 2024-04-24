package org.example.api.config.objectmapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ObjectMapperConfig {

	@Bean // ObjectMapper 객체를 Bean 에 등록한다는 뜻 (⭐️objectMapper 메소드를 등록한다는게 아님️️⭐️)
	public ObjectMapper objectMapper () {
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.registerModule(new Jdk8Module()); // JDK8 버전 이후 클래스를 처리하기 위한 코드
		objectMapper.registerModule(new JavaTimeModule()); // LocalDate 로 바꿔준다. (기존은 Date)

		// 모르는 Json filed(value) 에 대해서는 무시한다. -> 무시하고 파싱한다.
		// 100% 일치하는 값만 파싱할거냐, 모르는 값도 파싱 할거냐 -> 모르는 필드는 무시하고 진행한다.
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		// 비어있는 Bean 들을 생성할 때 어떻게 할지
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

		// 날짜 관련 직렬화
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		// 스네이크 케이스로 통일 시키겠다
		objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

		return objectMapper;

	}

}
