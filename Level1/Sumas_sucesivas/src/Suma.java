import java.util.Scanner;

public class Suma {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el primer valor: ");
        int a = scan.nextInt();
        System.out.println("Ingrese el segundo valor: ");
        int b = scan.nextInt();
        int res = a;
        for (int i = 1; i < b ; i++){
            res = res + a;
        }
        System.out.println("El resultado es: "+ res);
        scan.close();
    }
}
