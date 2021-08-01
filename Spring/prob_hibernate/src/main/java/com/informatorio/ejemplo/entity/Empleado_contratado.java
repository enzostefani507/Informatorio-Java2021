package com.informatorio.ejemplo.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado_contratado")
public class Empleado_contratado extends Empleado{
    private Integer monto;
    private String especialidad;
    private Date vencimiento;
   
    public Date getVencimiento(){
        return this.vencimiento;
    }

   public void setVencimiento(Date vencimiento){
        this.vencimiento = vencimiento;
   }


   public Integer getMonto(){
       return this.monto;
   }

   public void setMonto(Integer monto){
       this.monto = monto;
   }

   public String getEspecialidad(){
       return this.especialidad;
   }

   public void setSueldo_basico(String especialidad){
       this.especialidad = especialidad;
   }
}
