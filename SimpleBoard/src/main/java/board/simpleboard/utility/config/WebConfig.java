package board.simpleboard.utility.config;

import board.simpleboard.utility.Intercepter.OpenApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private OpenApiInterceptor openApiInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(openApiInterceptor)
         //       .addPathPatterns("/**"); //root 하위 모든 주소를 맵핑 하겠다는 뜻. 들어오는 모든 주소에 객체를 받아준다.
    }
}
