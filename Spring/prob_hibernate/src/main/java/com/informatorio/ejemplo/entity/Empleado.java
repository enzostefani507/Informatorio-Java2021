package com.informatorio.ejemplo.entity;

import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Empleado {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private Long id;
   private String nombre;
   private String apellido;
   private Date fecha_nacimiento;
   
    public Date getFecha_nacimiento(){
        return this.fecha_nacimiento;
    }

   public void setFecha_nacimiento(Date fecha_nacimietno){
        this.fecha_nacimiento = fecha_nacimietno;
   }

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getNombre() {
       return nombre;
   }

   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getApellido() {
       return apellido;
   }

   public void setApellido(String apellido) {
       this.apellido = apellido;
   }
}
