import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese numero para calcular factorial: ");
        int numero = scan.nextInt();
        int resultado = factorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
        scan.close();
    }

    public static int factorial(int num){
        int res = 1;
        for ( int i = num; i >= 1; i--){
            res = res*i;
        }
        return res;
    }

    
}
