package com.imprenta.tucan.service;

import com.imprenta.tucan.entity.Provincia;
import com.imprenta.tucan.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    // Obtener todas las provincias
    public List<Provincia> listarProvincias() {
        return provinciaRepository.findAll();
    }

    // Guardar una provincia nueva o actualizar existente
    public Provincia guardarProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    // Buscar provincia por ID
    public Optional<Provincia> obtenerProvinciaPorId(Long id) {
        return provinciaRepository.findById(id);
    }

    // Eliminar provincia por ID
    public void eliminarProvincia(Long id) {
        provinciaRepository.deleteById(id);
    }

    // Agregar métodos personalizados si querés filtrados por región, nombre, etc.
}
