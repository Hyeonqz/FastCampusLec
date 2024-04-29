package org.example.api.common.annotation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

@Target(ElementType.TYPE) // 어노테이션으로 동직시키기 위한 코드
@Retention(RetentionPolicy.RUNTIME) // 실행 중에 적용하는 것.
@Service // Bean 에도 추가. (스프링에서 이 어노테이션을 감지한다.) + Business 어노테이션도 다 감지를 한다.
public @interface Business {

	@AliasFor(annotation = Service.class) // 아래 메소드는 Service 어노테이션에 있는 value 를 뜻한다.
	String value() default "";

	// 이 어노테이션은 서비스에서 Component 만 없는 것이다.
}
