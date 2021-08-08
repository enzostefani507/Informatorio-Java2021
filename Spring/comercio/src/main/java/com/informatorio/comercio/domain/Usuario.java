package com.informatorio.comercio.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.informatorio.comercio.service.UsuarioService;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion = UsuarioService.creacion();

    @Column(nullable = false, updatable = true)
    private String direccion;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario")
    private List<Carrito> carritos = new ArrayList<>();

    //Getters
    public List<Carrito> getCarritos() {return carritos;}
    public String getDireccion() {return direccion;}
    public String getApellido() {return apellido;}
    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public Date getFecha_creacion() {return fecha_creacion;}

    //Setters
    public void setId(Long id) {this.id = id;}
    public void setCarritos(List<Carrito> carritos) {this.carritos = carritos;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setFecha_creacion(Date fecha_creacion) {this.fecha_creacion = fecha_creacion;}
}
