import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class App{
    static Map<Integer,String> alumnos = cargarMap();
    public static void main(String[] args){
        String nombre;
        try{
            //nombre = alumnos.get(0123);
            nombre = buscarAlumnoPorLegajo(01234);
            System.out.println("Tamaño del nombre :"+nombre.length());
        }catch(EntidadNoEncontradaException e){
            e.printStackTrace();
            System.out.println("============");
            System.out.println(e);
        }
        System.out.println("Operacion terminada");
    }

    public static String buscarAlumnoPorLegajo(Integer Legajo) throws EntidadNoEncontradaException{
        String nombre = alumnos.get(Legajo);
        if (Objects.isNull(nombre)){
            throw new EntidadNoEncontradaException("Legajo: " + Legajo + " no encontrado");
        }
        return nombre;
    }

    public static Map<Integer,String> cargarMap(){
        Map <Integer,String> alumnos = new HashMap<>();
        alumnos.put(1234,"Juan");
        alumnos.put(1231,"Maria");
        alumnos.put(1236,"Lisa");
        alumnos.put(6425,"Juank");
        return alumnos;
    }
}