package com.example.demo.services;

import com.example.demo.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

// Adapta a entidade Usuario para o formato que o Spring Security entende.
public class UserDetailsImpl implements UserDetails {

    private final Usuario usuario;

    public UserDetailsImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    // Converte o perfil do usuário (ADMIN ou VENDEDOR) para o formato de autoridade do Spring Security.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(usuario.getPerfil().name()));
    }

    @Override
    public String getPassword() {
        return usuario.getSenha(); // Retorna a senha criptografada do usuário.
    }

    @Override
    public String getUsername() {
        return usuario.getEmail(); // Usa o email como identificador do usuário.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuario.getAtivo(); // Retorna se o usuário está ativo no sistema.
    }
}