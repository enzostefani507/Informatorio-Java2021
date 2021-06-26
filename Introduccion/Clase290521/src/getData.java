import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class getData {
    public static void main(String args[]) throws IOException{
        String path = "/media/enzo/Datos/Informatorio/Etapa3/Java/Practica/Clase290521/data/Alumnos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line =  br.readLine();
            
            while ( line != null ){
                System.out.println(line);
                line = br.readLine();
                String [] datos  = line.split(",");
                Empleado e = new Empleado();
        
                e.first_name = datos[1];
                e.dni = datos[0];
                e.last_name = datos[2];

                System.out.println(e.toString());
            }
            
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
}
