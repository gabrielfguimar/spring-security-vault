package com.gabriel.securityvault.usecase;

import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.gateway.CriptografiaGateway;
import com.gabriel.securityvault.domain.model.Credencial;
import com.gabriel.securityvault.infrastructure.security.Auditavel;

public class SalvarCredencialUseCase {

    private final CredencialRepositoryGateway repositoryGateway;
    private final CriptografiaGateway criptografiaGateway;

    public SalvarCredencialUseCase(CredencialRepositoryGateway repositoryGateway, CriptografiaGateway criptografiaGateway) {
        this.repositoryGateway = repositoryGateway;
        this.criptografiaGateway = criptografiaGateway;
    }

    @Auditavel(acao = "SALVAR_CRED") // Auditoria aplicada aqui, na regra de negócio completa
    public Credencial executar(Credencial credencial) {
        // 1. Verifica duplicidade
        if (repositoryGateway.existePorNomeEUsuario(credencial.getNome(), credencial.getUsuario())) {
            throw new RuntimeException("Você já possui uma credencial salva para este usuário neste serviço!");
        }

        // 2. Criptografa a senha
        String senhaCifrada = criptografiaGateway.criptografar(credencial.getSenhaCifrada());

        // 3. Cria objeto de domínio
        Credencial credencialCifrada = new Credencial(
            null,
            credencial.getNome(),
            credencial.getUrl(),
            credencial.getUsuario(),
            senhaCifrada
        );

        // 4. Salva pelo gateway
        return repositoryGateway.salvar(credencialCifrada);
    }
}