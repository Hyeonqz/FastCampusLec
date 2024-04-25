package org.example.api.filter;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggerFilter implements Filter {

	@Override
	public void init (FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	// 우리가 수정할 부분은 이 부분 이다.
	@Override
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {

		// request 내용을 한번 읽어버리면, 뒷단에서 다시 읽어버릴 수 없도록 설정이 되어있다.
		// 그것을 캐싱해주는 래퍼클래스가 있기 떄문에 그것을 설정해준다.
		ContentCachingRequestWrapper req = new ContentCachingRequestWrapper( (HttpServletRequest) request);
		ContentCachingResponseWrapper res = new ContentCachingResponseWrapper( (HttpServletResponse) response);

		// 파라미터로 넘어온 request 와 response 를 넣어주는게 아닌, 우리가 직접 만들어 둔 req,res 객체를 필터에 넘겨준다.
		// 객체가 넘어 갔기 때문에, 뒷단에 컨트롤러, 인터셉터 등 뒷단에서 받는 request 는 랩핑된 객체들이 넘아가게 된다.
		// 필터 같은 경우는 request 가 들어오면 doFilter 를 기준으로 위에 로직이 실행전, 아래 로직이 실행 후 response 가 나가는 로직이다.
		chain.doFilter(req,res);

		// 가장 좋은 방법은 요청이 들어왔을 때, 헤더정보와 바디 정보를 찍어준다 (실행 전)
		// 그러기 위해서는 ContentCachingRequestWrapper 말고 별도의 다른 객체를 만들어서 사용하는게 좋다.

		// 우리는 ContentCachingRequestWrapper 가 제공하는 이후의 단에서 로그를 남기겠다.(필터 실행 후)


		// request 정보
		Enumeration<String> headerNames = req.getHeaderNames(); // header Name
		StringBuilder headerValues = new StringBuilder();

		// key value 구조 이므로 headerName 에 대한 값을 찍어본다.
		headerNames.asIterator().forEachRemaining(headerKey -> {
			String headerValue = req.getHeader(headerKey);

			// authorization-token : ???, user-agent : ??? 이런 형식으로 찍히게 작성함
			headerValues.append("[")
						.append(headerKey)
						.append(" : ")
						.append(headerValue)
						.append(" , ")
						.append("] ");
		});

		// RequestBody 정보 -> 요청이 들어올 때 로그
		// Client --------------------------------------------------> Server
		String requestBody = new String(req.getContentAsByteArray());
		String requestURI = req.getRequestURI();
		String method = req.getMethod();
		log.info("Request Info : URI : {}, Method : {}, header :  {} , body : {}", requestURI, method, headerValues, requestBody); // toString 을 안하는 이유는 Logger 에서 자동으로 toString() 을 호출 해준다.


		// Response 정보
		StringBuilder responseHeaderValues = new StringBuilder();

		res.getHeaderNames().forEach(headerKey -> {
			String headerValue = res.getHeader(headerKey);

			// authorization-token : ???, user-agent : ??? 이런 형식으로 찍히게 작성함
			responseHeaderValues.append("[")
				.append(headerKey)
				.append(" : ")
				.append(headerValue)
				.append(" , ")
				.append("] ");
		});

		// ResponseBody 정보 -> 응답이 나갈 때 로그
		// Server --------------------------------------------------> Client
		String responseBody = new String(res.getContentAsByteArray());
		log.info("Response Info : URI : {}, Method : {}, header :  {} , body : {}", requestURI, method, responseHeaderValues, responseBody); // toString 을 안하는 이유는 Logger 에서 자동으로 toString() 을 호출 해준다.


		// ⭐️ 중요한게 이미 req,res 내용을 읽어버렸기 때문에 다시 초기화를 시켜 호출을 해줘야 한다.
		// 아래 로직을 쓰지 않으면 responseBody 가 비어져서 나옵니다.
		res.copyBodyToResponse();

	}

	@Override
	public void destroy () {
		Filter.super.destroy();
	}

}
