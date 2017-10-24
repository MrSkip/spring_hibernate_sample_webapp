package de.m1well.spring.webapp.sample.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
public class SecurityWebAppInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebAppInitializer() {
        super(WebSecurityConfig.class);
    }
}