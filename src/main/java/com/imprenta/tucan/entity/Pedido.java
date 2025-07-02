package com.imprenta.tucan.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    private LocalDate fechaPedido;
    private String descripcionTrabajo;
    private String estado;
    private Double presupuesto;
    private LocalDate fechaEntrega;
    private String observaciones;
    private String archivoDiseño;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}
