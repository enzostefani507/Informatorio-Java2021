import java.util.Scanner;

public class a_mayuscula {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();
        char[] caracteres = entrada.toCharArray();
        for (int i = 0; i < caracteres.length; i++){
            if (caracteres[i] >= 'a' && caracteres[i] <= 'z') {
                caracteres[i] = (char)(caracteres[i] - (int) 'a' + (int) 'A');
            }
            System.out.print(caracteres[i]);
        }
        System.out.println();
        scan.close();
    }
}
