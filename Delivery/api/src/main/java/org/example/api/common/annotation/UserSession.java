package org.example.api.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 파라미터에서 사용할 것이다.
@Retention(RetentionPolicy.RUNTIME) // 실행 중에 사용할 것이다.
public @interface UserSession {
	//
}
