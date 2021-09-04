package com.informatorio.comercio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.comercio.service.CarritoService;

import javax.persistence.*;
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
    private Long carritoId;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion = CarritoService.creacion();

    @Column(updatable = false)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(unique = true,nullable = false)
    private Long numero;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Origen origen;

    @Column(nullable = false, length=200)
    private String observacion;

    //Setters
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void addLinea(Linea linea) {this.linea.add(linea);}
    public void setCarritoId(Long carritoId) {this.carritoId = carritoId;}
    public void setEstado(Estado estado) {this.estado = estado;}
    public void setTipo(Tipo tipo) {this.tipo = tipo;}
    public void setNumero(Long numero) {this.numero = numero;}
    public void setOrigen(Origen origen) { this.origen = origen;}
    public void setObservacion(String observacion) {this.observacion = observacion;}

    //Getters
    public Estado getEstado() { return estado;}
    public String getObservacion() { return observacion;}
    public Long getId() {return id;}
    public Long getUsuarioId(){return usuario.getId();}
    @JsonIgnore
    public Usuario getUsuario() {return usuario;}
    public List<Linea> getLinea() {return linea;}
    public Long getCarritoId() {return carritoId;}
    public Date getFecha_creacion() {return fecha_creacion;}
    public Tipo getTipo() {return tipo;}
    public Long getNumero() {return numero;}
    public Origen getOrigen() {return origen;}
    @Transient
    public Double getCostoTotal(){
        Double total = 0.0;
        for ( Linea l : this.getLinea()){
            total = l.getSubTotal() + total;
        }
        return total;
    }
}
