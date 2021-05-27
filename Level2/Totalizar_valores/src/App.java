import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) {
        
        List<Integer> horas = new ArrayList <Integer> ();
        horas.add(6);
        horas.add(7);
        horas.add(8);
        horas.add(4);
        horas.add(5);
        
        List<Integer> valor_hora = new ArrayList <Integer> ();
        valor_hora.add(350);
        valor_hora.add(345);
        valor_hora.add(550);
        valor_hora.add(600);
        valor_hora.add(320);

        List<Integer> semanal = new ArrayList <Integer> ();

        int total = 0;
        for (int i = 0; i < 5; i ++){
            semanal.add(valor_hora.get(i)*horas.get(i));
            total += semanal.get(i);
        }

        System.out.println(semanal);

        System.out.println(total);
    }
}
