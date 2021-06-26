import java.util.HashSet;

import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Set <String> nombres = new HashSet<>();
        cargarLista(nombres);

        System.out.println("Tamaño de la lista: "+nombres.size());
        
        for (String nombre: nombres){
            System.out.println(nombre);
        }
        
        System.out.println("Esta juan en la lista? -->"+ nombres.contains("Juan"));
        nombres.remove("Pablo");
        System.out.println("Tamaño de la lista: "+nombres.size());
    }

    public static void  cargarLista(Set<String> nombres){
        nombres.add("Juan");
        nombres.add("Juana");
        nombres.add("Pablo");
        nombres.add("Homero");
    }
}
