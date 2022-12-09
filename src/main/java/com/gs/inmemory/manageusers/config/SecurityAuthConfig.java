package com.gs.inmemory.manageusers.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityAuthConfig {
    	//Turning Basic Auth on for Spring Security

        @Bean
        protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .httpBasic()
                    .and()
                    .headers().frameOptions().sameOrigin()
                    .and()
                    .authorizeRequests((authorize) -> authorize
                        .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                        .anyRequest()
                        .authenticated());
                    
            return http.build();
        }

        @Bean
        PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
      
        @Bean
        protected InMemoryUserDetailsManager userDetailsService(){
            UserDetails nonadmin = User.builder().username("nonadmin")
                .password(passwordEncoder().encode("nonadmin")).roles("readOnly").build();
            UserDetails admin = User.builder().username("Admin")
                .password(passwordEncoder().encode("Password")).roles("ADMIN").build();
            return new InMemoryUserDetailsManager(nonadmin,admin);
        }
}
