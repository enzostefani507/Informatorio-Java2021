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
        System.out.println("Los empleados más jovenes : " + getMenorEdadEmpleados("04-06-2021"));

        //Empleado más viejo
        System.out.println("El empleados más viejos : " + getMayorEdadEmpleados("04-06-2021"));

        //Empleado que más gana
        System.out.println("Los empleados que más ganan : " + getMayorSalarioEmpleados()); 

        //Empleado que menos gana
        System.out.println("Los empleado que menos ganan : " + getMenorSalarioEmpleados()); 

        //Imprimri en orden alfabetico
        SetOrdenarApellido();
        SetOrdenarNombre();

         /*
        Extras utilizaos
        int emp_interes = 6;
        System.out.println("La edad de " + empleados.get(emp_interes) + " es : " + empleados.get(emp_interes).Edad("04-06-2021"));
        //System.out.println(MenorSueldo());
        //System.out.println(MayorSueldo());
        */
    
    }

    public static void SetOrdenarApellido(){
        empleados.sort(Comparator.comparing(Empleado::getApellido));
        System.out.println(empleados);
    }

    public static void SetOrdenarNombre(){
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

    public static double getMayorSueldo(){
        double mayor_sueldo = empleados.get(0).getSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() > mayor_sueldo){
                mayor_sueldo = e.getSueldo();
            }
        }
        return mayor_sueldo;
    }

    public static double getMenorSueldo(){
        double menor_sueldo = empleados.get(0).getSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() < menor_sueldo){
                menor_sueldo = e.getSueldo();
            }
        }
        return menor_sueldo;
    }

    public static int getMayorEdad(String fecha){
        int mayor_edad = empleados.get(0).getEdad(fecha);
        for (Empleado e: empleados){
            if (e.getEdad(fecha) > mayor_edad){
                mayor_edad = e.getEdad(fecha);
            }
        }
        return mayor_edad;
    }

    public static int getMenorEdad(String fecha){
        int menor_edad = empleados.get(0).getEdad(fecha);
        for (Empleado e: empleados){
            if (e.getEdad(fecha) < menor_edad){
                menor_edad = e.getEdad(fecha);
            }
        }
        return menor_edad;
    }

    public static List<Empleado> getMenorSalarioEmpleados(){
        List<Empleado> seleccion = new ArrayList<>();
        double menor_salario = getMenorSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() == menor_salario){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleado> getMayorSalarioEmpleados(){
        List<Empleado> seleccion = new ArrayList<>();
        double mayor_salario = getMayorSueldo();
        for (Empleado e: empleados){
            if (e.getSueldo() == mayor_salario){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleado> getMenorEdadEmpleados(String Fecha){
        List<Empleado> seleccion = new ArrayList<>();
        double menor_edad = getMenorEdad(Fecha);
        for (Empleado e: empleados){
            if (e.getEdad(Fecha) == menor_edad){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleado> getMayorEdadEmpleados(String Fecha){
        List<Empleado> seleccion = new ArrayList<>();
        double mayor_edad = getMayorEdad(Fecha);
        for (Empleado e: empleados){
            if (e.getEdad(Fecha) == mayor_edad){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }
}