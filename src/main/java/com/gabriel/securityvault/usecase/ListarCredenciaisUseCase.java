package com.gabriel.securityvault.usecase;

import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.gateway.CriptografiaGateway;
import com.gabriel.securityvault.domain.model.Credencial;
import java.util.List;

public class ListarCredenciaisUseCase {

    private final CredencialRepositoryGateway repositoryGateway;
    private final CriptografiaGateway criptografiaGateway;

    public ListarCredenciaisUseCase(CredencialRepositoryGateway repositoryGateway, CriptografiaGateway criptografiaGateway) {
        this.repositoryGateway = repositoryGateway;
        this.criptografiaGateway = criptografiaGateway;
    }

    public List<Credencial> executar() {
        List<Credencial> credenciais = repositoryGateway.listarTodas();

        credenciais.forEach(c -> {
            String senhaAberta = criptografiaGateway.descriptografar(c.getSenhaCifrada());
            c.setSenhaAbertaParaExibicao(senhaAberta);
        });

        return credenciais;
    }
}