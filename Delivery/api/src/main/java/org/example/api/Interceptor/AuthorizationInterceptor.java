package org.example.api.Interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("AuthorizationInterceptor url : {}", request.getRequestURI());

		// Web 유저를 위한 처리 -> Chrome 의 경우 get,post 경우 options 일 경우 pass
		if(HttpMethod.OPTIONS.matches(request.getMethod())) {
			return true;
		}

		// resource 검증 (API 검증 아님) js,html,css,png etc.. 일 경우 pass
		if(handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		// TODO Header 검증 예정

		return true;
	}

	@Override
	public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
