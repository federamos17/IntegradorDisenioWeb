package com.imprenta.tucan.service;

import com.imprenta.tucan.entity.Localidad;
import com.imprenta.tucan.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    // Obtener todas las localidades
    public List<Localidad> listarLocalidades() {
        return localidadRepository.findAll();
    }

    // Guardar una localidad nueva o actualizar existente
    public Localidad guardarLocalidad(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    // Buscar localidad por ID
    public Optional<Localidad> obtenerLocalidadPorId(Long id) {
        return localidadRepository.findById(id);
    }

    // Eliminar localidad por ID
    public void eliminarLocalidad(Long id) {
        localidadRepository.deleteById(id);
    }

    // Agregar métodos personalizados si querés filtrados por provincia, código postal, etc.
}
