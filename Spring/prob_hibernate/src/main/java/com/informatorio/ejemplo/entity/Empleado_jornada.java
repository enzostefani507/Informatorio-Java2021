package com.informatorio.ejemplo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado_jornada")
public class Empleado_jornada extends Empleado{
   private Integer precio_hora;

   public Integer getPrecio_hora(){
       return this.precio_hora;
   }

   public void setPrecio_hora(Integer precio_hora){
       this.precio_hora = precio_hora;
   }
}
