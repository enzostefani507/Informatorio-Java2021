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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_creacion;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private List<Producto> productos;

    @Column(nullable = false)
    private Boolean estado;

    public Calendar getFecha_creacion() {
        return this.fecha_creacion;
    }

    public long getId() {
        return this.id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Boolean getEstado() {
        return this.estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
