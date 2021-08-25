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
    private Orden orden;

    //Getters
    public Long getId() {return id;}
    public Long getProducto() {return producto_id;}
    public Integer getCantidad() {return cantidad;}
    public Double getPrecio() {return precio;}

    //Setters
    public void setProducto_id(Long producto_id) {this.producto_id = producto_id;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
    public void setPrecio(Double precio) {this.precio = precio;}
    public void setOrden(Orden orden) {this.orden = orden;}

}
