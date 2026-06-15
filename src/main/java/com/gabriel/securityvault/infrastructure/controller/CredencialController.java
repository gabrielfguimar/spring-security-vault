package com.gabriel.securityvault.infrastructure.controller;

import jakarta.validation.Valid; // Importante adicionar este import
import com.gabriel.securityvault.usecase.SalvarCredencialUseCase;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credenciais")
public class CredencialController {

    private final SalvarCredencialUseCase salvarCredencialUseCase;

    public CredencialController(SalvarCredencialUseCase salvarCredencialUseCase) {
        this.salvarCredencialUseCase = salvarCredencialUseCase;
    }

@PostMapping
@Operation(summary = "Salva uma nova credencial no cofre")
public ResponseEntity<String> salvar(@Valid @RequestBody CredencialRequest request) {
    this.salvarCredencialUseCase.executar(request.toDomain());
    return ResponseEntity.ok("Credencial salva com sucesso!");
}
}