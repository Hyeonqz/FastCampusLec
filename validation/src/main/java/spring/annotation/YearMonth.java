package spring.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import spring.validator.YearMonthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class}) // 어떠한 클래스로 검증을 할 것인지
@Target( {ElementType.FIELD}) //어디에다가 적용시킬지 -> 필드만 적용
@Retention(RetentionPolicy.RUNTIME) //언제 실행시킬 것 인지 -> 실행중에만 실행
@NotBlank //해당 값은 비어있으면 안됌
// @Size(min=8, max=8) //문자열이여야되고, 최소8글자 최대8글자로 제한한다.
public @interface  YearMonth {

    String pattern() default "Year month 양식에 맞지 않습니다 ex) 20230301";
    String defaultPattern() default "YYYYMMDD";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
