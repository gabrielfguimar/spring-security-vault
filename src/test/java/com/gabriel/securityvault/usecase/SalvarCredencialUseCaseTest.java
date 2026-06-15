package com.gabriel.securityvault.usecase;


import com.gabriel.securityvault.domain.gateway.CredencialRepositoryGateway;
import com.gabriel.securityvault.domain.gateway.CriptografiaGateway;
import com.gabriel.securityvault.domain.model.Credencial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalvarCredencialUseCaseTest {

    @Mock
    private CredencialRepositoryGateway repositoryGateway;

    @Mock
    private CriptografiaGateway criptografiaGateway;

    @InjectMocks
    private SalvarCredencialUseCase salvarCredencialUseCase;

    @Test
    void deveSalvarCredencialComSucesso() {
        // 1. Arrange (Preparação)
        Credencial credencial = new Credencial(null, "GitHub", "https://github.com", "user", "senha123");
        when(repositoryGateway.existePorNomeEUsuario(anyString(), anyString())).thenReturn(false);
        when(criptografiaGateway.criptografar("senha123")).thenReturn("senhaCifrada");
        when(repositoryGateway.salvar(any(Credencial.class))).thenReturn(credencial);

        // 2. Act (Execução)
        Credencial resultado = salvarCredencialUseCase.executar(credencial);

        // 3. Assert (Verificação)
        assertNotNull(resultado);
        verify(repositoryGateway, times(1)).salvar(any(Credencial.class));
    }

    @Test
    void deveLancarErroQuandoCredencialJaExistir() {
        // Arrange
        Credencial credencial = new Credencial(null, "GitHub", "https://github.com", "user", "senha123");
        when(repositoryGateway.existePorNomeEUsuario(anyString(), anyString())).thenReturn(true);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> salvarCredencialUseCase.executar(credencial));
    }
}