package com.gabriel.securityvault.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Desabilite apenas para testes locais
        .authorizeHttpRequests(auth -> auth
            // Libera o acesso ao Swagger e OpenAPI
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
            // Libera suas rotas de API (ajuste conforme necessário)
            .requestMatchers("/api/credenciais/**").permitAll() 
            .anyRequest().authenticated()
        );
    return http.build();
}}