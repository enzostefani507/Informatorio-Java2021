import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> alumnos = new ArrayList <String>();
        String [] nombres = {"Roberto","Manuel","Mabel","Julio","Pedrito","Sonia","Soledad","Micaela","Fede","Ly","Julio","Lucas"};
        
        for(int i=0; i < nombres.length-1; i++){
            alumnos.add(i,nombres[i]);
        }
        
        List<String> curso_1 = alumnos.subList(0, 3);
        List<String> curso_2 = alumnos.subList(4, 7);
        List<String> curso_3 = alumnos.subList(8, 11);

        System.out.println(alumnos);
        System.out.println("Curso1: "+curso_1);
        System.out.println("Curso2: "+curso_2);
        System.out.println("Curso3: "+curso_3);
    }
}
