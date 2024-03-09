package api.restapi.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class)
@Builder
public class UserResponse {

    private String id;
    private String name;
    private int age;

}
