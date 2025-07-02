package com.imprenta.tucan.repository;

import com.imprenta.tucan.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aquí podés agregar métodos personalizados si querés, ej:
    // List<Cliente> findByEstado(String estado);
}
