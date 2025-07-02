package com.imprenta.tucan.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalidad;

    @Column(nullable = false)
    private String nombreLocalidad;

    @Column(nullable = false)
    private String codPostal;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;
}
