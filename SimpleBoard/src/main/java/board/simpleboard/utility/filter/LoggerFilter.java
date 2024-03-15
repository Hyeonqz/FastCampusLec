package board.simpleboard.utility.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.stream.Collectors;


@Slf4j
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //진입 전
        log.info("진입 전");

        var req = new ContentCachingRequestWrapper( (HttpServletRequest) servletRequest);
        var res = new ContentCachingResponseWrapper( (HttpServletResponse) servletResponse);

     /*   var br = req.getReader();
        var list = br.lines().collect(Collectors.toList());

        list.forEach( it -> {
            log.info("{}",it);
        });*/

        filterChain.doFilter(req,res);
        var reqJson = new String(req.getContentAsByteArray());
        log.info("{}",reqJson);

        var resJson = new String(res.getContentAsByteArray());
        log.info("{}",resJson);

        log.info("진입 후");
        res.copyBodyToResponse();

    }
}
