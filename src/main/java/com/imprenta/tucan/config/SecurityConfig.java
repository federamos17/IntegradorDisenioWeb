package com.imprenta.tucan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()   // 🔓 Permite todo
            )
            .csrf(csrf -> csrf.disable())   // Sintaxis moderna: desactiva CSRF en dev
            .formLogin(form -> form.disable()); // Sintaxis moderna: desactiva login mientras tanto

        return http.build();
    }
}
