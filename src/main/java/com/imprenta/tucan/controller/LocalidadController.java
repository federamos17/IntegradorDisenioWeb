package com.imprenta.tucan.controller;

import com.imprenta.tucan.entity.Localidad;
import com.imprenta.tucan.service.LocalidadService;
import com.imprenta.tucan.service.ProvinciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/localidades")
@RequiredArgsConstructor
public class LocalidadController {

    private final LocalidadService localidadService;
    private final ProvinciaService provinciaService;

    // ✅ Mostrar formulario y lista de localidades
    @GetMapping("/gestionar")
    public String listarLocalidades(Model model) {
        model.addAttribute("localidad", new Localidad()); // Objeto vacío para el formulario
        model.addAttribute("localidades", localidadService.listarLocalidades()); // Lista actual de localidades
        model.addAttribute("provincias", provinciaService.listarProvincias()); // Para combo box de provincias
        return "localidades/gestion-de-localidad";
    }

    // ✅ Guardar nueva localidad
    @PostMapping("/guardar")
    public String guardarLocalidad(@ModelAttribute("localidad") Localidad localidad) {
        localidadService.guardarLocalidad(localidad);
        return "redirect:/localidades/gestionar";
    }

    // ✅ Eliminar localidad
    @GetMapping("/eliminar/{id}")
    public String eliminarLocalidad(@PathVariable Long id) {
        localidadService.eliminarLocalidad(id);
        return "redirect:/localidades/gestionar";
    }

}
