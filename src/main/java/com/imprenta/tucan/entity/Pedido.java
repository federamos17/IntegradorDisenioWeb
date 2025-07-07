package com.imprenta.tucan.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido;

    private String descripcionTrabajo;
    private String estado;
    private Double presupuesto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;
    
    private String observaciones;
    private String archivoDiseño;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}
