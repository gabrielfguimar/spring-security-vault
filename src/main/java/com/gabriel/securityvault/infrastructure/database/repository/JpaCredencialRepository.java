package com.gabriel.securityvault.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabriel.securityvault.infrastructure.database.entity.CredencialEntity;

public interface JpaCredencialRepository extends JpaRepository<CredencialEntity, Long> {
    
    // O Spring Data JPA vai gerar o SQL automaticamente a partir deste nome
    boolean existsByNomeAndUsuario(String nome, String usuario);
}