package com.gabriel.securityvault.infrastructure.config;

import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.gateway.CriptografiaGateway;
import com.gabriel.securityvault.usecase.ListarCredenciaisUseCase;
import com.gabriel.securityvault.usecase.SalvarCredencialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {

    @Bean
    public SalvarCredencialUseCase salvarCredencialUseCase(
            CredencialRepositoryGateway credencialRepositoryGateway,
            CriptografiaGateway criptografiaGateway) {
        return new SalvarCredencialUseCase(credencialRepositoryGateway, criptografiaGateway);
    }

    @Bean
    public ListarCredenciaisUseCase listarCredenciaisUseCase(
            CredencialRepositoryGateway gateway, 
            CriptografiaGateway criptografiaGateway) { // <- Ajustado de 'service' para 'criptografiaGateway'
        return new ListarCredenciaisUseCase(gateway, criptografiaGateway);
    }
}