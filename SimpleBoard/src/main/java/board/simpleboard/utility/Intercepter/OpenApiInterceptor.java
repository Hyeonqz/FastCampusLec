package board.simpleboard.utility.Intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // true 이면 controller 에 전달, false 면 Controller 에 전달하지 않는다.

        var handlerMethod = (HandlerMethod)handler;

        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class); //메소드에 OpenApi 어노테이션이 달려있는가를 본다

        if (methodLevel != null) {
            log.info("method level");
            return true;
        }

        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class); //클래스에 OpenApi 어노테이션이 달려있는가를 본다

        if (classLevel != null) {
            log.info("class Level");
            return true;
        }

        log.info("open api 아닙니다 . {}", request.getRequestURI());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("post handler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("after completion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
