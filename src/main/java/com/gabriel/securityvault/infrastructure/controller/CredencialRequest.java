package com.gabriel.securityvault.infrastructure.controller;

import com.gabriel.securityvault.domain.model.Credencial;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CredencialRequest(
    @Schema(description = "Nome do serviço ou aplicação", example = "GitHub")
    @NotBlank(message = "O nome é obrigatório")
    String nome, 

    @Schema(description = "Usuário de acesso", example = "gabriel_dev")
    @NotBlank(message = "O usuário é obrigatório")
    String usuario, 

    @Schema(description = "Senha de acesso", example = "senhaSecreta123")
    @NotBlank(message = "A senha é obrigatória")
    String senha, 

    @Schema(description = "URL do site", example = "https://github.com")
    @NotBlank(message = "A URL é obrigatória")
    String url
) {
    public Credencial toDomain() {
        return new Credencial(null, this.nome, this.url, this.usuario, this.senha);
    }
}