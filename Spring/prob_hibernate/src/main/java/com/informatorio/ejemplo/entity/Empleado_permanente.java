package com.informatorio.ejemplo.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado_permanente")
public class Empleado_permanente extends Empleado{
    private Integer sueldo_basico;
    private String puesto;
    private Date fecha_de_inicio;
   
    public Date getFecha_de_inicio(){
        return this.fecha_de_inicio;
    }

   public void setFecha_de_inicio(Date fecha_de_inicio){
        this.fecha_de_inicio = fecha_de_inicio;
   }


   public String getPuesto(){
       return this.puesto;
   }

   public void setPuesto(String puesto){
       this.puesto = puesto;
   }

   public Integer getSueldo_basico(){
       return this.sueldo_basico;
   }

   public void setSueldo_basico(Integer sueldo_basico){
       this.sueldo_basico = sueldo_basico;
   }
}
