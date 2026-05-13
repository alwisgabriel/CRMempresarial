package com.example.demo.exception;

/**
 * Exceção lançada quando um recurso solicitado não é encontrado no banco.
 * Exemplos: empresa, contato ou oportunidade inexistente.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}