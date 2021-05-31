public class Empleado{
    private int dni;
    private String nombre;
    private String apellido;

    public Empleado(int dni, String nombre, String apellido){
        //Defino el constructor
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        //Sobre escribo toString para mostrar el objeto de forma personalizada
        return this.dni + "-" + this.apellido;
    }
}