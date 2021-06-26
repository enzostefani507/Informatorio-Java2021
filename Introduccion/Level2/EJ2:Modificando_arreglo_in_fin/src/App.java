import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int [] numeros = {2,3,4,5};
        int long_orig = numeros.length;
        
        int long_nuevo = long_orig+2;
        int [] nueva_lista = new int [long_nuevo];
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese nuevo valor inicial: ");
        int inicio = scan.nextInt();
        System.out.println("Ingrese nuevo valor final: ");
        int fin = scan.nextInt();

        nueva_lista[0] = inicio;
        
        for (int i = 0; i < numeros.length; i++){
            nueva_lista[i+1] = numeros[i];
        }

        nueva_lista[long_orig+1] = fin;

        System.out.println("Tamaño antes: "+ long_orig);
        System.out.println("Tamaño antes: "+ long_nuevo);
        System.out.println("Array nuevo:\n"+ Arrays.toString(nueva_lista));
        scan.close();
    }
}
