import java.util.Scanner;

public class Escritura_escalonada {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);  
        int num = scan.nextInt();
        for (int i = 0; i <= num+1 ; i ++){
            for (int j = 1; j < i ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        scan.close();
    }
}
