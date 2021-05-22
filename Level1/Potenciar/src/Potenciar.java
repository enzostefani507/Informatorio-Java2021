import java.util.Scanner;

public class Potenciar {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese base");
        int a = scan.nextInt();
        System.out.println("Ingrese potencia");
        int b = scan.nextInt();
        int r = a;
        for (int i = 1 ; i < b; i ++){
            r = r*a;
        }
        System.out.println(a + "^" + b +"=" + r);
        scan.close();
    }
}

