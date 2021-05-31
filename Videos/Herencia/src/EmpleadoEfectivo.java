public class EmpleadoEfectivo extends Empleado{
    private int sueldo;
    private int antiguedad;

    public EmpleadoEfectivo(int dni, String nombre, String apellido, int sueldo, int antiguedad){
        super(dni,nombre,apellido);
        this.antiguedad = antiguedad;
        this.sueldo = sueldo;
    }

    @Override
    public int calcularSueldo() {
        return this.sueldo + this.antiguedad* 1000;
    }
}
