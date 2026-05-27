package com.gabriel.securityvault.domain.gateway;

import com.gabriel.securityvault.domain.model.Credencial;
import java.util.List;

public interface CredencialRepositoryGateway {
    Credencial salvar(Credencial credencial);
    boolean existePorNomeEUsuario(String nome, String usuario);
    List<Credencial> listarTodas(); // <- Adicione esta linha
}