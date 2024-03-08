package api.restapi;

import api.restapi.dto.UserRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        var user = new UserRequestDTO();
        user.setUserName("jin");
        user.setUserAge(25);
        user.setEmail("23@naver.com");
        user.setIskorean(true);

        var json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        var dto = objectMapper.readValue(json,UserRequestDTO.class);
        System.out.println(dto.toString());
    }

}
