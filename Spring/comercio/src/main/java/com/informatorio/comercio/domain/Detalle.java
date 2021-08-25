package com.informatorio.comercio.domain;

import javax.persistence.*;

@Entity
public class Detalle {
    /*
        Brinda informacion de la cantidad de un cierto producto para dar esta informacion al Carrito y/o Compra.
        - producto
        - cantidad
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "producto", referencedColumnName = "id")
    private Producto producto;

    @Column(nullable = false,updatable = true)
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Carrito carrito;

    //Getters
    public Long getId() {return id;}
    public Producto getProducto() {return producto;}
    public Integer getCantidad() {return cantidad;}

    //Setters
    public void setProducto(Producto producto) {this.producto = producto;}
    public void setCarrito(Carrito carrito) {this.carrito = carrito;}
    public void incCantidad() {this.cantidad += 1;}
    public void decCantidad() {this.cantidad -= 1;}

    public Detalle() {
        this.cantidad = 1;
    }
}
