package com.gabriel.securityvault.infrastructure.api;

import com.gabriel.securityvault.domain.model.Credencial;
import com.gabriel.securityvault.usecase.ListarCredenciaisUseCase;
import com.gabriel.securityvault.usecase.SalvarCredencialUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/credenciais")
public class CredencialController {

    private final SalvarCredencialUseCase salvarCredencialUseCase;
    private final ListarCredenciaisUseCase listarCredenciaisUseCase;

    public CredencialController(SalvarCredencialUseCase salvarCredencialUseCase, ListarCredenciaisUseCase listarCredenciaisUseCase) {
        this.salvarCredencialUseCase = salvarCredencialUseCase;
        this.listarCredenciaisUseCase = listarCredenciaisUseCase;
    }

    @PostMapping
    public ResponseEntity<CredencialResponse> salvar(@RequestBody CredencialRequest request) {
        // Instancia o modelo de domínio esperado pelo método executar
        Credencial novaCredencial = new Credencial(
            null,
            request.nome(),
            request.url(),
            request.usuario(),
            request.senha() 
        );

        Credencial salva = salvarCredencialUseCase.executar(novaCredencial);

        CredencialResponse response = new CredencialResponse(
            salva.getId(),
            salva.getNome(),
            salva.getUrl(),
            salva.getUsuario(),
            salva.getSenhaCifrada(),
            null
        );

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CredencialResponse>> listar() {
        List<Credencial> credenciais = listarCredenciaisUseCase.executar();

        List<CredencialResponse> response = credenciais.stream()
            .map(c -> new CredencialResponse(
                c.getId(),
                c.getNome(),
                c.getUrl(),
                c.getUsuario(),
                c.getSenhaCifrada(),
                c.getSenhaAbertaParaExibicao()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}