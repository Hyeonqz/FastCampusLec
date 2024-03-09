package spring.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRegister {

    //@NotNull  // !=null
    //@NotEmpty // != null && name != "" && name != " " 공백이 있는것도 안됌
    @NotBlank // != null && name != ""
    private String name;

    @Size(min=1, max=12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(150) // 정수는 Size를 할 수 없다
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}(?:-|\\s)?\\d{3,4}(?:-|\\s)?\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.") //휴대폰 번호 정규식
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;
}
