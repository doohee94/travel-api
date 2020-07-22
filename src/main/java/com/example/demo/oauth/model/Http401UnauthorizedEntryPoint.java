package com.example.demo.oauth.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * security 사용히 401에러로 인증되지 않는 사람이 들어올 경우 이 부분에서 처리(?)
 *
 * @createBy DO
 * @Date 2020.06.13
 *
 * */
public class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    private final Logger log = LoggerFactory.getLogger(Http401UnauthorizedEntryPoint.class);

    /**
     * Always returns a 401 error code to the client.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
            throws IOException,
            ServletException {

        log.debug("Pre-authenticated entry point called. Rejecting access");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
        response.setHeader("Accept","application/json");
    }
}
