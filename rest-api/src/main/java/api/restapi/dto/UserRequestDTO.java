package api.restapi.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRequestDTO {
    private String userName;
    private Integer userAge;
    private String email;
    private Boolean iskorean;

    public String name() {
        return this.userName;
    }

    public Integer age() {
        return this.userAge;
    }
}
