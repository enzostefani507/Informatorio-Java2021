import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class App {
    private static List<Empleado> empleados = new ArrayList<>();
    public static void main(String args[]) throws IOException{
        //Paso el registro txt a objetos
        RegistrarEmpleados();

        //Empleados que comienzan con una letra
        char buscado = 'b';
        System.out.println("Los empleados cuyo apellido comienza con " + buscado + " son: " + BuscarApellido(buscado));

        //Empleado más joven
        System.out.println("Los empleados más jovenes : " + MenorEdadEmpleados("04-06-2021"));

        //Empleado más viejo
        System.out.println("El empleados más viejos : " + MayorEdadEmpleados("04-06-2021"));

        //Empleado que más gana
        System.out.println("Los empleados que más ganan : " + MayorSalarioEmpleados()); 

        //Empleado que menos gana
        System.out.println("Los empleado que menos ganan : " + MenorSalarioEmpleados()); 

        //Imprimri en orden alfabetico
        OrdenarApellido();
        OrdenarNombre();

         /*
        Extras utilizaos
        int emp_interes = 6;
        System.out.println("La edad de " + empleados.get(emp_interes) + " es : " + empleados.get(emp_interes).Edad("04-06-2021"));
        //System.out.println(MenorSueldo());
        //System.out.println(MayorSueldo());
        */
    
    }

    public static void OrdenarApellido(){
        empleados.sort(Comparator.comparing(Empleado::getApellido));
        System.out.println(empleados);
    }

    public static void OrdenarNombre(){
        empleados.sort(Comparator.comparing(Empleado::getNombre));
        System.out.println(empleados);
    }

    public static void RegistrarEmpleados(){
        String path = "/media/enzo/Datos/Informatorio/Etapa3/Java/Practica/Clase030621/data/Empleados.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line =  br.readLine();
            while ( line != null ){
                InstanciarEmpleado(line);
                line = br.readLine();
            }
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }

    public static void InstanciarEmpleado(String linea){
        if (linea != null){
            linea = linea.toUpperCase();
            String[] info = linea.split(",");
            Empleado e = new Empleado(info[0], info[1], info[2], info[3]);
            empleados.add(e); 
        }  
    }

    public static List<Empleado> BuscarApellido(char letra){
        List<Empleado> encontrados = new ArrayList<>();
        for (Empleado e: empleados){
            if (e.getApellido().charAt(0) == Character.toUpperCase(letra)){
                encontrados.add(e);
            }
        }
        return encontrados;
    }    

    public static double MayorSueldo(){
        double mayor_sueldo = empleados.get(0).getSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() > mayor_sueldo){
                mayor_sueldo = e.getSueldo();
            }
        }
        return mayor_sueldo;
    }

    public static double MenorSueldo(){
        double menor_sueldo = empleados.get(0).getSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() < menor_sueldo){
                menor_sueldo = e.getSueldo();
            }
        }
        return menor_sueldo;
    }

    public static int MayorEdad(String fecha){
        int mayor_edad = empleados.get(0).Edad(fecha);
        for (Empleado e: empleados){
            if (e.Edad(fecha) > mayor_edad){
                mayor_edad = e.Edad(fecha);
            }
        }
        return mayor_edad;
    }

    public static int MenorEdad(String fecha){
        int menor_edad = empleados.get(0).Edad(fecha);
        for (Empleado e: empleados){
            if (e.Edad(fecha) < menor_edad){
                menor_edad = e.Edad(fecha);
            }
        }
        return menor_edad;
    }

    public static List<Empleado> MenorSalarioEmpleados(){
        List<Empleado> seleccion = new ArrayList<>();
        double menor_salario = MenorSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() == menor_salario){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleado> MayorSalarioEmpleados(){
        List<Empleado> seleccion = new ArrayList<>();
        double mayor_salario = MayorSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() == mayor_salario){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleado> MenorEdadEmpleados(String Fecha){
        List<Empleado> seleccion = new ArrayList<>();
        double menor_edad = MenorEdad(Fecha);
        for (Empleado e: empleados){
            if (e.Edad(Fecha) == menor_edad){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleado> MayorEdadEmpleados(String Fecha){
        List<Empleado> seleccion = new ArrayList<>();
        double mayor_edad = MayorEdad(Fecha);
        for (Empleado e: empleados){
            if (e.Edad(Fecha) == mayor_edad){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }
}