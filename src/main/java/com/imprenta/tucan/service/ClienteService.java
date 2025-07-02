package com.imprenta.tucan.service;

import com.imprenta.tucan.entity.Cliente;
import com.imprenta.tucan.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Guardar un cliente nuevo o actualizar existente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Buscar cliente por ID
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Agregar métodos personalizados si querés filtrados por estado, nombre, etc.
}
