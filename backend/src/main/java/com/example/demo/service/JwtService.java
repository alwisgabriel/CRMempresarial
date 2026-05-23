package com.example.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

// Serviço responsável por gerar e validar tokens JWT.
@Service
public class JwtService {

    // Chave secreta usada para assinar o token. Deve ter no mínimo 256 bits.
    private static final String SECRET_KEY = "chave-secreta-super-segura-para-o-crm-senaisales";

    // Tempo de expiração do token: 24 horas em milissegundos.
    private static final long EXPIRACAO = 1000 * 60 * 60 * 24;

    // Gera a chave de assinatura a partir da chave secreta.
    // Atualizado: agora retorna SecretKey em vez de Key
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Gera um token JWT para o usuário autenticado.
    public String gerarToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername()) // antigo setSubject
                .issuedAt(new Date())               // antigo setIssuedAt
                .expiration(new Date(System.currentTimeMillis() + EXPIRACAO)) // antigo setExpiration
                .signWith(getSigningKey())          // antigo signWith (agora infere o algoritmo automaticamente)
                .compact();
    }

    // Extrai o email do usuário a partir do token.
    public String extrairEmail(String token) {
        return extrairClaims(token).getSubject();
    }

    // Valida se o token pertence ao usuário e não está expirado.
    public boolean tokenValido(String token, UserDetails userDetails) {
        return extrairEmail(token).equals(userDetails.getUsername()) && !tokenExpirado(token);
    }

    // Verifica se o token está expirado.
    private boolean tokenExpirado(String token) {
        return extrairClaims(token).getExpiration().before(new Date());
    }

    // Extrai todas as informações (claims) contidas no token.
    private Claims extrairClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // antigo setSigningKey
                .build()
                .parseSignedClaims(token)    // antigo parseClaimsJws
                .getPayload();               // antigo getBody
    }
}