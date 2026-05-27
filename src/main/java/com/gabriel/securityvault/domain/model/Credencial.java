package com.gabriel.securityvault.domain.model;

import java.time.LocalDateTime;

public class Credencial {
    private Long id;
    private String nome;
    private String url;
    private String usuario;
    private String senhaCifrada;
    private LocalDateTime dataCriacao;
    private String senhaAbertaParaExibicao; // Campo para o fluxo de GET

    // Construtor completo
    public Credencial(Long id, String nome, String url, String usuario, String senhaCifrada) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.usuario = usuario;
        this.senhaCifrada = senhaCifrada;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getUrl() { return url; }
    public String getUsuario() { return usuario; }
    public String getSenhaCifrada() { return senhaCifrada; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }

    public String getSenhaAbertaParaExibicao() { 
        return senhaAbertaParaExibicao; 
    }
    
    public void setSenhaAbertaParaExibicao(String senhaAbertaParaExibicao) { 
        this.senhaAbertaParaExibicao = senhaAbertaParaExibicao; 
    }
}