package com.informatorio.comercio.domain;

import javax.persistence.*;

@Entity
public class Linea {
    /*
        - producto_id
        - cantidad
        - precio
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,updatable = false)
    private Long producto_id;

    @Column(nullable = false,updatable = false)
    private Integer cantidad;

    @Column(nullable = false,updatable = false)
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Carrito orden;

    //Getters
    public Long getId() {return id;}
    public Long getProducto() {return producto_id;}
    public Integer getCantidad() {return cantidad;}
    public Double getPrecio() {return precio;}
}
