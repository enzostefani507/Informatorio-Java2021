package com.informatorio.comercio.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatorio.comercio.service.CarritoService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("carritos")
    private List<Producto> productos = new ArrayList<>();

    //Getters
    public Long getId() {return id;}
    public Boolean getEstado() {return estado;}
    public Usuario getUsuario() {return usuario;}
    public Date getFecha_creacion() {return fecha_creacion;}
    public List<Producto> getProductos() {return productos;}

    //Setters
    public void addProducto(Producto producto){this.getProductos().add(producto);producto.addCarrito(this);}
    public void removeProducto(Producto producto){this.getProductos().remove(producto);producto.removeCarrito(this);}
    public void setId(Long id) {this.id = id;}
    public void setEstado(Boolean estado) {this.estado = estado;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void setFecha_creacion(Date fecha_creacion) {this.fecha_creacion = fecha_creacion;}

}
