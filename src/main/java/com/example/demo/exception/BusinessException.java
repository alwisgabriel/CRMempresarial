package com.example.demo.exception;

/**
 * Exceção lançada quando uma regra de negócio é violada.
 * Exemplos: CNPJ duplicado, vendedor tentando editar cliente de outro vendedor.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}