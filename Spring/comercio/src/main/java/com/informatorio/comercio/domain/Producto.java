package com.informatorio.comercio.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {
    /*
      Esta clase representa los productos del comercio y tiene los siguientes atributos
        - nombre
        - descripcion
        - precio_unitario
        - carritos
        - codigo_inventario
        - categoria
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Debe ingresar un nombre.")
    @Size(min = 2, message = "El nombre debe tener minimamente 2 caracteres")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "Debe ingresar una descripcion.")
    @Size(min = 5, message = "La descripcion debe tener minimamente 5 caracteres")
    private String descripcion;

    @Column(nullable = false,precision = 2, scale = 0)
    private Double precio_unitario;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Debe ingresar el codigo del producto.")
    private String codigo_inventario;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;

    @OneToOne(mappedBy = "producto")
    private Detalle detalle;

    //Getters
    public String getCodigo_inventario() {return codigo_inventario;}
    public String getDescripcion() {return descripcion;}
    public String getNombre() {return nombre;}
    public Double getPrecio_unitario() {return precio_unitario;}
    public Long getId() {return id;}
    public Categoria getCategoria() {return categoria;}

    //Setters
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
