package com.informatorio.comercio.domain;

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
    private Long carrito_id;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion = CarritoService.creacion();

    @Column(updatable = false)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(unique = true)
    private Integer numero;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    //Setters
    public void setId(Long id) {this.id = id;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void addLinea(Linea linea) {this.linea.add(linea);}
    public void setCarrito_id(Long carrito_id) {this.carrito_id = carrito_id;}
    public void setEstado(Estado estado) {this.estado = estado;}
    public void setTipo(Tipo tipo) {this.tipo = tipo;}
    public void setNumero(Integer numero) {this.numero = numero;}

    //Getters
    public Estado getEstado() { return this.estado;}

}
