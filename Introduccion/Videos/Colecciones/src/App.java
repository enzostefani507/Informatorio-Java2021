import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List <String> nombres = new ArrayList<>();
        cargarLista(nombres);

        System.out.println("Tamaño de la lista: "+nombres.size());
        
        for (String nombre: nombres){
            System.out.println(nombre);
        }
        
        System.out.println("Esta juan en la lista? -->"+ nombres.contains("Juan"));
        nombres.remove("Pablo");
        System.out.println("Tamaño de la lista: "+nombres.size());
    }

    public static void  cargarLista(List<String> nombres){
        nombres.add("Juan");
        nombres.add("Juana");
        nombres.add("Pablo");
        nombres.add("Homero");
    }
}
