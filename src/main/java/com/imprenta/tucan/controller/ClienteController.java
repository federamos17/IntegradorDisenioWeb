package com.imprenta.tucan.controller;

import com.imprenta.tucan.entity.Cliente;
import com.imprenta.tucan.entity.Localidad;
import com.imprenta.tucan.entity.Provincia;
import com.imprenta.tucan.service.ClienteService;
import com.imprenta.tucan.service.LocalidadService;
import com.imprenta.tucan.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private LocalidadService localidadService;

    @Autowired
    private ProvinciaService provinciaService;

    // Mostrar lista de clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "clientes/gestion-de-clientes"; // Thymeleaf template
    }

    // Mostrar formulario para nuevo cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("localidades", localidadService.listarLocalidades());
        model.addAttribute("provincias", provinciaService.listarProvincias());
        return "clientes/alta-cliente"; // Thymeleaf template
    }

    // Guardar cliente (nuevo o editado)
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    // Mostrar formulario para editar cliente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.obtenerClientePorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("cliente", cliente);
        model.addAttribute("localidades", localidadService.listarLocalidades());
        model.addAttribute("provincias", provinciaService.listarProvincias());
        return "clientes/alta-cliente";
    }

    // Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
