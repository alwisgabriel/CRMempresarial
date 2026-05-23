package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.example.demo.enums.PerfilUsuario;

// Entidade que representa um usuário do sistema.
// Mapeada para a tabela "usuarios" no banco de dados.
@Entity
@Table(name = "usuarios")
public class Usuario {

    // Chave primária gerada automaticamente pelo banco.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome completo do usuário. Não pode ser nulo.
    @Column(nullable = false)
    private String nome;

    // Email do usuário. Não pode ser nulo e deve ser único no banco.
    @Column(nullable = false, unique = true)
    private String email;

    // Senha do usuário. Será armazenada criptografada com BCrypt.
    @Column(nullable = false)
    private String senha;

    // Perfil do usuário: ADMIN ou VENDEDOR.
    // Armazenado como texto no banco (ex: "ADMIN"), não como número.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilUsuario perfil;

    // Indica se o usuário está ativo. Começa como true por padrão.
    @Column(nullable = false)
    private Boolean ativo = true;

    // Data e hora do cadastro. Preenchida automaticamente e nunca alterada.
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    // Getters e Setters — permitem acessar e modificar os atributos privados.

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public PerfilUsuario getPerfil() { return perfil; }
    public void setPerfil(PerfilUsuario perfil) { this.perfil = perfil; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
}