package com.example.demo.repository;

import com.example.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// Repositório responsável pelas operações de banco de dados da entidade Usuario.
// O JpaRepository já fornece os métodos básicos: save, findById, findAll, delete, etc.
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca um usuário pelo email. Retorna Optional pois o usuário pode não existir.
    Optional<Usuario> findByEmail(String email);
}