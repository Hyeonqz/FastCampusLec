package com.delivery.api.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter implements Filter {

    // 필터를 통한 로그 설정
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = new ContentCachingRequestWrapper( (HttpServletRequest)request );
        var res = new ContentCachingResponseWrapper( (HttpServletResponse)response );

        // 위가 실행전 (=객체가 들어오기전)

       // 뒷단에서 객체가 넘어갔기 때문에 뒷단의 컨트롤러나 인터셉터 등 리퀘스트는 랩핑된 객체들이 넘어간다.
        chain.doFilter(req,res);

        // 위가 실행 후 (=객체가 들어온 후)

        // request 정보
        var headerNames = req.getHeaderNames();
        StringBuilder headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining( headerKey -> {
            var headerValue = req.getHeader(headerKey);

            headerValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ");
        });

        String requestBody = new String(req.getContentAsByteArray());
        var uri = req.getRequestURI();
        var method = req.getMethod();
        log.info("실행 전 로그");
        log.info("URI : {} , Method : {} ", uri,method);
        log.info("Header : {} , body : {}",headerValues,requestBody);

        // response 정보
        var responseHeaderValues = new StringBuilder();

        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);

            responseHeaderValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ");
        });

        var responseBody =  new String(res.getContentAsByteArray());
        log.info("실행 후 로그");
        log.info("URI : {} , Method : {}", uri, method);
        log.info("Header : {} , body : {}",responseHeaderValues,responseBody);

        res.copyBodyToResponse(); // 미리 사용한 정보를 다시 채워 넣어야함

    }




}
