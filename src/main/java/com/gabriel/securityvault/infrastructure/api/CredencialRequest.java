package com.gabriel.securityvault.infrastructure.api;

public record CredencialRequest(
    String nome,
    String url,
    String usuario,
    String senha
) {}