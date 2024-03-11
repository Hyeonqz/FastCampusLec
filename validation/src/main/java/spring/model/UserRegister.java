package spring.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.annotation.PhoneNumber;
import spring.annotation.YearMonth;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRegister {

    //@NotNull  // !=null
    //@NotEmpty // != null && name != "" && name != " " 공백이 있는것도 안됌
    @NotBlank // != null && name != ""
    private String name;

    private String nickName;

    @Size(min=1, max=12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(150) // 정수는 Size를 할 수 없다
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth(pattern = "yyyy-MM")
    private String birthDayYearMonth;

    @AssertTrue(message = "name or nickName은 1개는 존재해야 합니다.") //is가 들어간 boolean 반환에만 작동함
    public boolean isNameCheck() {

        if(Objects.nonNull(name) && !name.isBlank()) {
            return true;
        }

        if(Objects.nonNull(nickName) && !nickName.isBlank()) {
            return true;
        }

        return false;
    }
}
