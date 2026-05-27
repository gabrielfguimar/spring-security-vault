package com.gabriel.securityvault.infrastructure.database.repository;

import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.model.Credencial;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@Component
public class InMemoryCredencialRepository implements CredencialRepositoryGateway {

    private final Map<Long, Credencial> bancoEmMemoria = new HashMap<>();
    private Long idContador = 1L;

    @Override
    public Credencial salvar(Credencial credencial) {
        Credencial salva = new Credencial(
            idContador,
            credencial.getNome(),
            credencial.getUrl(),
            credencial.getUsuario(),
            credencial.getSenhaCifrada()
        );
        bancoEmMemoria.put(idContador, salva);
        idContador++;
        return salva;
    }

    @Override
    public boolean existePorNomeEUsuario(String nome, String usuario) {
        return bancoEmMemoria.values().stream()
                .anyMatch(c -> c.getNome().equalsIgnoreCase(nome) && c.getUsuario().equalsIgnoreCase(usuario));
    }

    @Override
    public List<Credencial> listarTodas() {
        return new ArrayList<>(bancoEmMemoria.values());
    }
}