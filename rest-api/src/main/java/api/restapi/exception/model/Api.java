package api.restapi.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Api<T> {
    private String resultCode;
    private String resultMessage;
    private T data;


}
