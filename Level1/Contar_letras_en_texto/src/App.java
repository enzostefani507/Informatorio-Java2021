import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese un texto: ");
        String texto = scan.nextLine();
        System.out.println("Ingrese letra a contar: ");
        char caracter = scan.next().charAt(0);
        /*REVISAR LECTURA DE CARACTER*/
        
        char[] letras = texto.toCharArray();
        int cantidad = 0;

        for (int i = 0; i < letras.length; i++){
            if (letras[i] == caracter){
                cantidad++;
            }

        }

        System.out.println("Caracteres encontrados: "+ cantidad);
        scan.close();

    }
}
