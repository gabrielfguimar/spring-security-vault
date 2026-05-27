package com.gabriel.securityvault.infrastructure.database.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_credenciais")
public class CredencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String url;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false, name = "senha_cifrada")
    private String senhaCifrada;

    @Column(nullable = false, name = "data_criacao")
    private LocalDateTime dataCriacao;

    // Construtor padrão exigido pelo Hibernate
    public CredencialEntity() {}

    public CredencialEntity(Long id, String nome, String url, String usuario, String senhaCifrada) {
    this.id = id;
    this.nome = nome;
    this.url = url;
    this.usuario = usuario;
    this.senhaCifrada = senhaCifrada;
}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getSenhaCifrada() { return senhaCifrada; }
    public void setSenhaCifrada(String senhaCifrada) { this.senhaCifrada = senhaCifrada; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}