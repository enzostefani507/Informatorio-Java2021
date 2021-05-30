import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewFile {
    public static void main(String args[]) throws IOException{
        String path = "/media/enzo/Datos/Informatorio/Etapa3/Java/Practica/Clase290521/data/Alumnos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line =  br.readLine();
            
            while ( line != null ){
                System.out.println(line);
                line = br.readLine();
            }
        }catch(IOException ioe){
            System.out.println("Problem: "+ioe);
        }
    }
}
