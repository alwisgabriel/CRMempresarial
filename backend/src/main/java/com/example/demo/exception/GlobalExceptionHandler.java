package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Tratamento global de exceções da aplicação.
 * Intercepta erros lançados em qualquer camada e retorna
 * uma resposta JSON padronizada com status, mensagem e timestamp.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Monta o corpo padrão da resposta de erro.
     *
     * @param status  código HTTP do erro
     * @param message mensagem descritiva do erro
     * @return mapa com status, mensagem e timestamp
     */
    private Map<String, Object> buildError(HttpStatus status, String message) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", status.value());       // Ex: 404, 400, 500
        error.put("message", message);             // Mensagem legível do erro
        error.put("timestamp", LocalDateTime.now()); // Momento em que o erro ocorreu
        return error;
    }

    /**
     * Trata erros de recurso não encontrado (404).
     * Lançado quando um cliente, contato ou oportunidade não existe.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    /**
     * Trata erros de regra de negócio (400).
     * Lançado quando uma validação falha, como CNPJ duplicado.
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusiness(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buildError(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    /**
     * Trata erros não mapeados (500).
     * Captura qualquer exceção inesperada para evitar expor detalhes internos.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildError(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor"));
    }
}