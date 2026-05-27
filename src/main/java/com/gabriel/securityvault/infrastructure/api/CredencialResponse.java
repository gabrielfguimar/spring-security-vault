package com.gabriel.securityvault.infrastructure.api;

public record CredencialResponse(
    Long id,
    String nome,
    String url,
    String usuario,
    String senhaCifrada,
    String senhaAbertaParaExibicao
) {}