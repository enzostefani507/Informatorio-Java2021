public class Empleado{
    int dni;
    String nombre;
    String apellido;

    public Empleado(int dni, String nombre, String apellido){
        //Defino el constructor
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    @Override
    public String toString() {
        //Sobre escribo toString para mostrar el objeto de forma personalizada
        return this.dni + "-" + this.apellido;
    }
}