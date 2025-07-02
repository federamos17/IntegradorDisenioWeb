package com.imprenta.tucan.repository;

import com.imprenta.tucan.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Para login más adelante
    Usuario findByNombre(String nombre);
}
