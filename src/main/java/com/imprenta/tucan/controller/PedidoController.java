package com.imprenta.tucan.controller;

import com.imprenta.tucan.entity.Pedido;
import com.imprenta.tucan.entity.Cliente;
import com.imprenta.tucan.service.PedidoService;
import com.imprenta.tucan.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    // ✅ Mostrar lista de pedidos
    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "pedidos/gestion-de-pedidos";
    }

    // ✅ Mostrar formulario para nuevo pedido
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPedido(Model model) {
        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);

        // Necesitamos los clientes para relacionar
        model.addAttribute("clientes", clienteService.listarClientes());

        return "pedidos/alta-pedido";
    }

    // ✅ Guardar pedido (nuevo o editado)
    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute("pedido") Pedido pedido) {
        pedidoService.guardarPedido(pedido);
        return "redirect:/pedidos";
    }

    // ✅ Mostrar formulario para editar pedido
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de pedido inválido: " + id));

        System.out.println("Fecha Pedido: " + pedido.getFechaPedido()); // DEBUG
        System.out.println("Fecha Entrega: " + pedido.getFechaEntrega()); // DEBUG

        model.addAttribute("pedido", pedido);

        // Lista de clientes para seleccionar si se quiere cambiar
        model.addAttribute("clientes", clienteService.listarClientes());

        return "pedidos/alta-pedido";
    }

    // ✅ Eliminar pedido
    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return "redirect:/pedidos";
    }

    // ✅ Ver detalles de un pedido
    @GetMapping("/ver/{id}")
    public String verDetallesPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de pedido inválido: " + id));
        model.addAttribute("pedido", pedido);
        return "pedidos/detalle-pedido";
    }

}
