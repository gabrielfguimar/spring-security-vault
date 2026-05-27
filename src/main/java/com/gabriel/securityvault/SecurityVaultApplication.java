package com.gabriel.securityvault;

import com.gabriel.securityvault.domain.model.Credencial;
import com.gabriel.securityvault.usecase.SalvarCredencialUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityVaultApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityVaultApplication.class, args);
    }

    @Bean
    CommandLineRunner executarTesteInicial(SalvarCredencialUseCase salvarCredencialUseCase) {
        return args -> {
            System.out.println("\n===[TESTE] Tentando salvar uma credencial de forma segura...===");

            // Passa o objeto Credencial completo para o UseCase
            Credencial credencialParaTeste = new Credencial(
                null, 
                "AWS S3 Production", 
                "https://aws.amazon.com/s3", 
                "gabriel_admin", 
                "MinhasenhaSuperSecreta123!"
            );

            Credencial resultado = salvarCredencialUseCase.executar(credencialParaTeste);

            System.out.println("[SUCESSO] Credencial processada pelo Core!");
            System.out.println("ID gerado no Banco: " + resultado.getId());
            System.out.println("Nome do Escopo: " + resultado.getNome());
            System.out.println("Usuário: " + resultado.getUsuario());
            System.out.println("Senha Cifrada salva em Banco (AES 256): " + resultado.getSenhaCifrada());
        };
    }
}