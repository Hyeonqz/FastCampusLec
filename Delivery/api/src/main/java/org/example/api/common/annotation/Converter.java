package org.example.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Service
public @interface Converter {

	// 데이터 변환을 하는 곳에 명시적으로 표현하기 위해서 만든 어노테이션
	// DTO <-> Entity
	// A <-> B
	@AliasFor(annotation = Service.class)
	String value() default "";
}
