import java.util.Scanner;

public class Ejercicio6_1 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int continuar = 1;
        int nro;
        while (continuar == 1){
            System.out.println("Por favor, ingrese un número: ");
            nro = scan.nextInt();
            System.out.println("El numero ingresado es" + nro);
            
            System.out.println("Si desea presione 1, sino otro valor");
            continuar = scan.nextInt();
        }
        scan.close();
    }
}
