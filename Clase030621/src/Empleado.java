import java.time.*;
import java.time.format.DateTimeFormatter;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private double sueldo ;

    public double getSueldo() {
        return sueldo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = Double.parseDouble(sueldo);
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimietno) {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fecha_nacimiento = LocalDate.parse(fecha_nacimietno,formatter);
    }

    public Empleado(String nombre, String apellido, String fecha_nacimietno, String sueldo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setSueldo(sueldo);
        this.setFecha_nacimiento(fecha_nacimietno);   
    }

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getApellido();
    }

    public int Edad(String fecha_hoy){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate hoy = LocalDate.parse(fecha_hoy,formatter);
        int dia_hoy = hoy.getDayOfMonth();
        int mes_hoy = hoy.getMonthValue();
        int anio_hoy = hoy.getYear();
        int edad = anio_hoy - this.fecha_nacimiento.getYear();
        if (mes_hoy < fecha_nacimiento.getMonthValue()){
            edad = edad -1;
        }
        if (mes_hoy == fecha_nacimiento.getMonthValue()){
            if (dia_hoy < fecha_nacimiento.getDayOfMonth()){
                edad = edad -1;
            }
        }
        return edad;
    }
}
