package com.informatorio.comercio.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatorio.comercio.service.UsuarioService;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


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

    //Getters
    public String getDireccion() {return direccion;}
    public String getApellido() {return apellido;}
    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public Date getFecha_creacion() {return fecha_creacion;}

    //Setters
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setFecha_creacion(Date fecha_creacion) {this.fecha_creacion = fecha_creacion;}
}
