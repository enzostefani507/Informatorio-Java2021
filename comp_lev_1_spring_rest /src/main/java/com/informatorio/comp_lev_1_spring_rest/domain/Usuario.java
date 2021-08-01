package com.informatorio.comp_lev_1_spring_rest.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;
    
    private String direccion;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritoList;

    @Column(updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_Alta;

    public Long getId() {
        return this.id;
    }

    public String getnombre() {
        return this.nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido() {
        return this.apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getdireccion() {
        return this.direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public Calendar getfecha_Alta() {
        return this.fecha_Alta;
    }

    public void setfecha_Alta(Calendar fecha_Alta) {
        this.fecha_Alta = fecha_Alta;
    }

    public List<Carrito> getCarritoList() {
        return this.carritoList;
    }

    public void setCarritoList(List<Carrito> carritoList) {
        this.carritoList = carritoList;
    }

    public Usuario(){}
}
