package com.informatorio.comercio.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio_unitario;

    @ManyToMany(mappedBy = "productos")
    private List<Carrito> carritos = new ArrayList<>();

    //Getters
    public List<Carrito> getCarritos() {return carritos;}
    public Long getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Double getPrecio_unitario() {
        return precio_unitario;
    }
    public String getNombre() {
        return nombre;
    }

    //Setters
    public void addCarrito(Carrito carrito) {this.getCarritos().add(carrito);}
    public void removeCarrito(Carrito carrito){this.getCarritos().remove(carrito);}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
