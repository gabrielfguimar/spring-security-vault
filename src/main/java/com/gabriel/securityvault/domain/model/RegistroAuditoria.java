package com.gabriel.securityvault.domain.model;

import java.time.LocalDateTime;

public record RegistroAuditoria(
    String id,
    String usuario,
    String acao,
    String recursoId,
    String status,
    LocalDateTime dataHora
) {
    // Construtor auxiliar para novos registros antes de salvar
    public static RegistroAuditoria criar(String usuario, String acao, String recursoId, String status) {
        return new RegistroAuditoria(null, usuario, acao, recursoId, status, LocalDateTime.now());
    }
}