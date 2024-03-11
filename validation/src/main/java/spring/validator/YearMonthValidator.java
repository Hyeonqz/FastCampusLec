package spring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.annotation.PhoneNumber;
import spring.annotation.YearMonth;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth,String> { //검증 메소드
    private String pattern;
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern=constraintAnnotation.defaultPattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //value는 UserRegister에서 넘어오는 값이다.
        // "20230101"
        // size = 8 이 맞는지 부터 확인

        // yyyy MM dd
        var reValue = value+"01";
        var rePattern = pattern+"dd";

        try {
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
