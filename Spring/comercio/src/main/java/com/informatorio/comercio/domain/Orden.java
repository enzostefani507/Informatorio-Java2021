package com.informatorio.comercio.domain;

import com.informatorio.comercio.service.CarritoService;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orden {

    /*
        - usuario
        - linea
        - carrito_id
        - fecha_creacion
        - Tipo
        - numero
        - estado (multivaluado, CONFIRMADA y CANCELADA)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy = "orden",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Linea> linea = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private Long carrito_id;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion = CarritoService.creacion();

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado estado;
}
