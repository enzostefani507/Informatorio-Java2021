package com.informatorio.comercio.domain;

import com.informatorio.comercio.service.CarritoService;

import javax.persistence.*;
import java.util.Date;



@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean estado = true;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion = CarritoService.creacion();

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    //Getters
    public Long getId() {return id;}
    public Boolean getEstado() {return estado;}
    public Usuario getUsuario() {return usuario;}
    public Date getFecha_creacion() {return fecha_creacion;}

    //Setters
    public void setId(Long id) {this.id = id;}
    public void setEstado(Boolean estado) {this.estado = estado;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void setFecha_creacion(Date fecha_creacion) {this.fecha_creacion = fecha_creacion;}

}
