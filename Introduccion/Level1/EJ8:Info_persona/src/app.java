import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        String nombre;
        String apellido;
        String edad;
        String direccion;
        String ciudad;

        Scanner scan = new Scanner(System.in);
        System.out.println("Nombre: ");
        nombre = scan.nextLine();
        System.out.println("Apellido: ");
        apellido = scan.nextLine();
        System.out.println("Edad: ");
        edad = scan.nextLine();
        System.out.println("Direccion: ");
        direccion = scan.nextLine();
        System.out.println("Ciudad: ");
        ciudad = scan.nextLine();

        Persona persona = new Persona( nombre,  apellido,  edad,  direccion,  ciudad);

        System.out.println(persona.getCiudad() +"-"+ persona.getDireccion()+"-"+persona.getEdad()+"-"+persona.getNombre()+"-"+persona.getApellido());

        scan.close();
    }
}
