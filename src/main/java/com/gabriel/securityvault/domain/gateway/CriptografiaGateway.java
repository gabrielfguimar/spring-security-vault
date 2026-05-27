package com.gabriel.securityvault.domain.gateway;

public interface CriptografiaGateway {
    String criptografar(String textoPuro);
    String descriptografar(String textoCifrado); // <- Adicione esta linha
}