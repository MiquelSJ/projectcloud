package com.learningjava.rest.spring.front.seguretat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration

public class ConfSeguretat extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobalSecurity (AuthenticationManagerBuilder au) throws Exception {
        au.inMemoryAuthentication().withUser("administrador").password("1234").roles("ADMINISTRADOR");
        au.inMemoryAuthentication().withUser("usuari").password("1234").roles("USUARI");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/", "/public/**").permitAll()
                .antMatchers("/rest/api/v1/restaurants").hasRole("ADMINISTRADOR")
                .antMatchers("/restUse.html").hasRole("ADMINISTRADOR")
                .and().formLogin()
                .and().httpBasic()
                .and().logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/").permitAll();
    }
}


