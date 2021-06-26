import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Map <Integer, String> alumnos = new HashMap<>();
        cargarMap(alumnos);
        
        for (Map.Entry <Integer,String> registro: alumnos.entrySet()){
            System.out.println("Id " + registro.getKey() + " Nombre: " + registro.getValue());
        }
        
        for (Integer clave: alumnos.keySet()){
            System.out.println("Id: " + clave);
        }

        for (String valor: alumnos.values()){
            System.out.println("Nombre " + valor);
        }

        System.out.println(alumnos.containsKey(136));
        System.out.println(alumnos.containsValue("Pablo"));
    }
    public static void  cargarMap(Map<Integer,String> nombres){
        nombres.put(136,"Juan");
        nombres.put(653,"Juana");
        nombres.put(643,"Pablo");
        nombres.put(233,"Homero");
    }
}

