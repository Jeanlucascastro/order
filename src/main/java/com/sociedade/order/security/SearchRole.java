package com.sociedade.order.security;

import com.sociedade.order.client.AuthClient;
import com.sociedade.order.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Component("searchRole")
public class SearchRole {
    private static final Logger log = LoggerFactory.getLogger(SearchRole.class);

    private final AuthClient authClient;

    private final HttpServletRequest httpServletRequest;

    private final JWTUtils jwtUtils;

    public SearchRole(AuthClient authClient, HttpServletRequest httpServletRequest, JWTUtils jwtUtils) {
        this.authClient = authClient;
        this.httpServletRequest = httpServletRequest;
        this.jwtUtils = jwtUtils;
    }

    public boolean hasPermission(String nomeMetodo) {

        String token = httpServletRequest.getHeader("Authorization");
        if (token != null && !token.isEmpty()) {
            token = token.replaceFirst("Bearer ", "");
        }
        return authClient.validateToken(jwtUtils.getUsernameFromToken(token), token);
    }


}
