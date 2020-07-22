package com.example.demo.oauth.config;

import com.example.demo.oauth.model.Http401UnauthorizedEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 *
 * @createBy DO
 * @Date 2020.06.13
 *
 * */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider authenticationProvider;

    //시큐리티에서 swagger 의 접근을 허용해 줍니다.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/webjars/**", "/swagger/**",
                        "/swagger-ui.html", "/swagger-resources", "/swagger-resources/**",
                        "/api/v2/api-docs", "/v2/api-docs",
                        "/configuration/security", "/configuration/ui")
                .antMatchers("/css/**", "/js/**", "/img/**")
                .antMatchers("/actuator", "/actuator/**")
//                .antMatchers("/api/user/sign-in", "/api/user/sign-up/member")
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }


    //권한 없는 사용자 처리 (인증 실패)
    @Bean
    public Http401UnauthorizedEntryPoint http401UnauthorizedEntryPoint() {
        return new Http401UnauthorizedEntryPoint();
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        //h2 console 설정 위해
        security.csrf().disable()
                .headers().frameOptions().disable();

        security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        security.exceptionHandling()
                .authenticationEntryPoint(http401UnauthorizedEntryPoint());


        security
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/h2-console", "/h2-console/**").permitAll()
                .antMatchers("/api/travel/**").permitAll()
                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/company/**").permitAll()
                .anyRequest().denyAll();

        security
                .formLogin().disable();

        security
                .httpBasic().disable();

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
