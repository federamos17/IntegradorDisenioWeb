package com.imprenta.tucan.controller;

import com.imprenta.tucan.entity.Provincia;
import com.imprenta.tucan.service.ProvinciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provincias")
@RequiredArgsConstructor
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    @GetMapping("/gestionar")
    public String listarProvincias(Model model) {
        model.addAttribute("provincia", new Provincia()); // <-- NUEVO
        model.addAttribute("provincias", provinciaService.listarProvincias());
        return "provincias/gestion-de-provincia";
    }

    // ✅ Guardar provincia
    @PostMapping("/guardar")
    public String guardarProvincia(@ModelAttribute("provincia") Provincia provincia) {
        provinciaService.guardarProvincia(provincia);
        return "redirect:/provincias/gestionar";
    }

    // ✅ Eliminar provincia
    @GetMapping("/eliminar/{id}")
    public String eliminarProvincia(@PathVariable Long id) {
        provinciaService.eliminarProvincia(id);
        return "redirect:/provincias/gestionar";
    }

}
