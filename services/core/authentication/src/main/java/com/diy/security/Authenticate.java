package com.diy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class Authenticate {
    @Autowired
    SecurityConfig securityConfig;

    public void authenticate(String email, String password) throws Exception {
        securityConfig.authenticationManagerBean().authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );
    }
}
