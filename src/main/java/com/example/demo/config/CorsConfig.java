package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuração global de CORS (Cross-Origin Resource Sharing).
 * Permite que o frontend React, rodando em outro endereço,
 * consiga se comunicar com esta API sem ser bloqueado pelo navegador.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Define as regras de CORS para todos os endpoints da aplicação.
     *
     * @param registry objeto onde as regras de CORS são registradas
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica as regras em todos os endpoints
                .allowedOrigins("http://localhost:3000") // Permite requisições apenas do frontend React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("Authorization", "Content-Type") // Cabeçalhos permitidos nas requisições
                .allowCredentials(true); // Permite envio de cookies e tokens de autenticação
    }
}