import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public List <Integer> numeros = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese primer valor");
        int num1 = scan.nextInt();
        System.out.println("Ingrese segundo valor");
        int num2 = scan.nextInt();

        String [] inv = new String[num2-num1];
        int c = 0;
        inv[c] = num1+"";
        inv[num2-num1-1] = (num2-1)+"";
        
        c = c +1;

        for (int i = num1+1; i < num2; i ++){
            if ( multiplo2(i) == true){
                inv[c] = "Fizz";
            }
            if ( multiplo3(i) == true){
                inv[c] = " Buzz";    
            }
            if (multiplo2(i) == true & multiplo3(i) == true){
                inv[c] = "Fizz Buzz";
            }
            if (multiplo2(i) == false & multiplo3(i) == false){
                inv[c] = i+"";
            }
            c = c+1;
        }

        for (int z = 0 ; z < inv.length; z ++){
            System.out.print(inv[z]+" ");
        }
        scan.close();
    }


    public static boolean multiplo2(int numero){
        return (numero % 2 == 0);
    }

    public static boolean multiplo3(int numero){
        return (numero % 3 == 0);
    }
}
