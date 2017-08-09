package com.lypgod.fbs.Filters;

import com.lypgod.fbs.Common.Exception.AuthenticationException;
import com.lypgod.fbs.Common.Util.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthenticationException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String auth = httpRequest.getHeader("Authorization");
        if ((auth == null) || (auth.length() <= 0)) {
            throw new AuthenticationException("无权限!");
        } else {
            try {
                Claims claims = JWTUtils.parseJWT(auth);
            } catch (ExpiredJwtException e) {
                throw new AuthenticationException("权限过期!");
            }
        }

//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.setCharacterEncoding("UTF-8");
//        httpResponse.setContentType("application/json; charset=utf-8");
//        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        resultMsg = new ResultMsg(ResultStatusCode.INVALID_TOKEN.getErrcode(), ResultStatusCode.INVALID_TOKEN.getErrmsg(), null);
//        httpResponse.getWriter().write(mapper.writeValueAsString(resultMsg));
    }

    @Override
    public void destroy() {

    }
}
