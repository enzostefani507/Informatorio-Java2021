public class Persona {
    private String nombre;
    private String apellido;
    private String edad;
    private String direccion;
    private String ciudad;

    public Persona(String nombre, String apellido, String edad, String direccion, String ciudad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = apellido;
        this.direccion = apellido;
        this.ciudad = apellido;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }

    public String getEdad(){
        return this.edad;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public String getCiudad(){
        return this.ciudad;
    }
}