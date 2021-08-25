package com.informatorio.comercio.domain;

import javax.persistence.*;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = true)
    private String numero;

    @Column(nullable = false, updatable = true)
    private String calle;

    @Column(nullable = false, updatable = true)
    private String barrio;

    @Column(nullable = false, updatable = true)
    private String ciudad;

    @OneToOne(mappedBy = "direccion")
    private Usuario usuario;

    //Getters
    public Long getId() {return id;}
    public Usuario getUsuario() {return usuario;}
    public String getNumero() {return numero;}
    public String getCalle() {return calle;}
    public String getBarrio() {return barrio;}
    public String getCiudad() {return ciudad;}

    //Setters
    public void setNumero(String numero) {this.numero = numero;}
    public void setCalle(String calle) {this.calle = calle;}
    public void setBarrio(String barrio) {this.barrio = barrio;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
