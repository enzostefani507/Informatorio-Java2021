package com.informatorio.comercio.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatorio.comercio.service.UsuarioService;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler",})
public class Usuario {

    /*
      Esta clase representa a los clientes del comercio, y tiene los siguientes atributos.
        - nombre
        - apellido
        - fecha_creacion
        - direccion
        - carritos
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = true)
    @NotBlank(message = "Debe ingresar un nombre.")
    @Size(min = 2, message = "El nombre debe tener minimamente 2 caracteres")
    private String nombre;

    @Column(nullable = false, updatable = true)
    @NotBlank(message = "Debe ingresar un apellido.")
    @Size(min = 2, message = "El apellido debe tener minimamente 2 caracteres")
    private String apellido;

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion = UsuarioService.creacion();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="direccion_id", referencedColumnName = "id")
    @JsonIgnoreProperties("usuario")
    private Direccion direccion;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario")
    private List<Carrito> carritos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario")
    private List<Orden> ordenes = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Rol rol;

    @Column(nullable = false,unique = true)
    @Email(regexp = ".+@.+\\..+",message = "Provea un email valido")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean activo = true;

    //Getters
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public Direccion getDireccion() {return direccion;}
    public List<Carrito> getCarritos() {return carritos;}
    public List<Orden> getOrdenes() {return ordenes;}
    public Long getId() {return id;}
    public Date getFechaCreacion() {return fechaCreacion;}
    public Rol getRol() {return  this.rol;}
    public String getEmail() { return email;}
    public String pwd() { return password;}
    public Boolean getActivo() { return activo;}

    //Setters
    public void setDireccion(Direccion direccion) {this.direccion = direccion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setRol(Rol rol) {this.rol = rol;}
    public void setEmail(String email) { this.email = email;}
    public void setPassword(String password) { this.password = password;}
    public void setCambiarEstado(){ this.activo = !this.activo;}

}
