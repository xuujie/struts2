package org.superbiz.struts;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/list", "/actuator", "actuator/health", "/actuator/info").permitAll()
                .antMatchers("/addUser", "/actuator/*").authenticated()
                .and()
                .httpBasic()
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
        ;
    }

}
