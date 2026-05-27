package com.gabriel.securityvault.usecase;

import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.gateway.CriptografiaGateway;
import com.gabriel.securityvault.domain.model.Credencial;

public class SalvarCredencialUseCase {

    private final CredencialRepositoryGateway repositoryGateway;
    private final CriptografiaGateway criptografiaGateway;

    public SalvarCredencialUseCase(CredencialRepositoryGateway repositoryGateway, CriptografiaGateway criptografiaGateway) {
        this.repositoryGateway = repositoryGateway;
        this.criptografiaGateway = criptografiaGateway;
    }

    public Credencial executar(Credencial credencial) {
        // 1. Verifica duplicidade se necessário
        if (repositoryGateway.existePorNomeEUsuario(credencial.getNome(), credencial.getUsuario())) {
            throw new RuntimeException("Você já possui uma credencial salva para este usuário neste serviço!");
        }

        // 2. Criptografa a senha usando o gateway do AES
        String senhaCifrada = criptografiaGateway.criptografar(credencial.getSenhaCifrada());

        // 3. Cria um novo objeto de domínio contendo a senha encriptada
        Credencial credencialCifrada = new Credencial(
            null,
            credencial.getNome(),
            credencial.getUrl(),
            credencial.getUsuario(),
            senhaCifrada
        );

        // 4. Salva de forma definitiva pelo repositório
        return repositoryGateway.salvar(credencialCifrada);
    }
}