package com.gabriel.securityvault.infrastructure.security;

import com.gabriel.securityvault.domain.gateway.CriptografiaGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class AesCriptografiaService implements CriptografiaGateway {

    private final SecretKeySpec secretKey;

    // O Spring vai injetar o valor do application.properties aqui
    public AesCriptografiaService(@Value("${security.aes.key}") String chaveSecreta) {
        byte[] chaveBytes = chaveSecreta.getBytes(StandardCharsets.UTF_8);
        
        // Fail-fast: Trava a aplicação na subida se a chave for inválida
        if (chaveBytes.length != 16 && chaveBytes.length != 24 && chaveBytes.length != 32) {
            throw new IllegalArgumentException("A chave AES configurada deve ter exatamente 16, 24 ou 32 bytes (caracteres). Tamanho atual: " + chaveBytes.length);
        }
        
        this.secretKey = new SecretKeySpec(chaveBytes, "AES");
    }

    @Override
    public String criptografar(String textoPuro) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] criptografado = cipher.doFinal(textoPuro.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(criptografado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar dados", e);
        }
    }

    @Override
    public String descriptografar(String textoCifrado) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodificado = Base64.getDecoder().decode(textoCifrado);
            byte[] textoPuroBytes = cipher.doFinal(decodificado);
            return new String(textoPuroBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar dados", e);
        }
    }
}