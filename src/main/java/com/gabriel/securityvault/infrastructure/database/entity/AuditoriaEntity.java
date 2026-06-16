package com.gabriel.securityvault.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "auditoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String acao;

    @Column(name = "recurso_id")
    private String recursoId;

    @Column(nullable = false)
    private String status;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}