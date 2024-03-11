package spring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.annotation.PhoneNumber;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> { //검증 메소드
    private String regexp;
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.defaultPattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //value는 UserRegister에서 넘어오는 값이다.
        boolean result = Pattern.matches(value,regexp);
        return result;
    }
}
