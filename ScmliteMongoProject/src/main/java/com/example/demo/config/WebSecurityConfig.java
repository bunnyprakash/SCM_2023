package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder
                .authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        .cors()
        .and()
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .mvcMatchers("/signup","/register","/login","/submitsignupdeatils","/shipment/create","/forgotpassword","/device","/register","/create").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").defaultSuccessUrl("/",true).failureUrl("/loginerror").permitAll();
		return http.build();
	}

}