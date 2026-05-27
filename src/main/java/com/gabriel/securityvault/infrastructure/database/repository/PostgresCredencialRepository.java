package com.gabriel.securityvault.infrastructure.database.repository;

import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.model.Credencial;
import com.gabriel.securityvault.infrastructure.database.entity.CredencialEntity;

import org.springframework.context.annotation.Primary;
import java.util.List;
import java.util.stream.Collectors;

@Primary
public class PostgresCredencialRepository implements CredencialRepositoryGateway {

    private final JpaCredencialRepository jpaRepository;

    public PostgresCredencialRepository(JpaCredencialRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Credencial salvar(Credencial credencial) {
        CredencialEntity entity = new CredencialEntity(
            null,
            credencial.getNome(),
            credencial.getUrl(),
            credencial.getUsuario(),
            credencial.getSenhaCifrada()
        );
        CredencialEntity salva = jpaRepository.save(entity);
        return new Credencial(
            salva.getId(), 
            salva.getNome(), 
            salva.getUrl(), 
            salva.getUsuario(), 
            salva.getSenhaCifrada()
        );
    }

    @Override
    public boolean existePorNomeEUsuario(String nome, String usuario) {
        return jpaRepository.existsByNomeAndUsuario(nome, usuario);
    }

    @Override
    public List<Credencial> listarTodas() {
        return jpaRepository.findAll().stream()
            .map(entity -> new Credencial(
                entity.getId(),
                entity.getNome(),
                entity.getUrl(),
                entity.getUsuario(),
                entity.getSenhaCifrada()
            ))
            .collect(Collectors.toList());
    }
}