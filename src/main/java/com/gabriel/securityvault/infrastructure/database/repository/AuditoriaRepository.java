package com.gabriel.securityvault.infrastructure.database.repository;

import com.gabriel.securityvault.infrastructure.database.entity.AuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity, UUID> {
}