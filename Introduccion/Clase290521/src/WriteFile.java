import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    /*
    This class write a register class instances in the file indicate in the path
    */
    public static void main(String[] args){
        Empleado[] registrados = registerEmployee();
        writeEmployee(registrados);
    }

    public static Empleado[] registerEmployee(){
        /* This method simulate register for employees*/
        Empleado e1 = new Empleado();
        Empleado e2 = new Empleado();
        Empleado e3 = new Empleado();
        Empleado e4 = new Empleado();
        
        e1.first_name = "Roberto";
        e1.dni = "123455677";
        e1.last_name = "Manu";

        e2.first_name = "Jona";
        e2.dni = "123455677";
        e2.last_name = "Luca";

        e3.first_name = "Franc";
        e3.dni = "123455677";
        e3.last_name = "Zoe";

        e4.first_name = "Antonio";
        e4.dni = "123455677";
        e4.last_name = "Fede";

        Empleado[] news = { e1, e2, e3, e4};
    
        return news;
    }

    public static void writeEmployee(Empleado[] listEmployees){
        String path = "/media/enzo/Datos/Informatorio/Etapa3/Java/Practica/Clase290521/data/Empleados.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

            for (int i = 0; i <= listEmployees.length-1; i++){
                String line = listEmployees[i].dni+","+listEmployees[i].last_name+","+listEmployees[i].first_name;
                bw.write(line+"\n");
            }
            
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
}

