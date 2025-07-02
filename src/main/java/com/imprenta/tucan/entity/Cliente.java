package com.imprenta.tucan.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaAlta;

    private String estado;  // Ejemplo: ACTIVO, INACTIVO

    @ManyToOne
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}
