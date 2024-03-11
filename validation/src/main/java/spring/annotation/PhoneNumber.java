package spring.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import spring.validator.PhoneNumberValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PhoneNumberValidator.class}) // 어떠한 클래스로 검증을 할 것인지
@Target( {ElementType.FIELD}) //어디에다가 적용시킬지 -> 필드만 적용
@Retention(RetentionPolicy.RUNTIME) //언제 실행시킬 것 인지 -> 실행중에만 실행

public @interface PhoneNumber {

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "핸드폰 번호 양식에 맞지 않습니다 ex) 000-0000-0000";
    String defaultPattern() default "^\\d{2,3}(?:-|\s)?\\d{3,4}(?:-|\s)?\\d{4}$";
}
