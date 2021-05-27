import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        HashSet<Empleado> empleados = new HashSet<Empleado>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        Empleado e1 = new Empleado();
        e1.apellido = "Benites";
        e1.nombre = "Enzo";
        e1.dni = "12345677";
        e1.horasTrabajadas = 40;
        e1.valorPorHora = 1000;

        Empleado e2 = new Empleado();
        e2.apellido = "Stefani";
        e2.nombre = "Lucas";
        e2.dni = "11235677";
        e2.horasTrabajadas = 90;
        e2.valorPorHora = 2500;

        empleados.add(e1);
        empleados.add(e2);

        System.out.println("Empleados:" + empleados);

        for (Empleado temp : empleados) {
            int sueldo = temp.horasTrabajadas*temp.valorPorHora;
            map.put(temp.dni,sueldo);
        }

        System.out.println("Dni=Sueldo: "+map);
    }
}
