import java.util.Scanner;

public class App {

    public static String menu = "Seleccione una opcion: 2 ,3, 4, 5";
    public static String separador = "=========================================================";
    public static void main(String[] args) throws Exception {
        int continuar = 1;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println(separador);
            System.out.println(menu);
            int opcion = scan.nextInt();
            switch (opcion){
                case 2:
                    Ejercicio2(scan);
                    break;
                case 3:
                    Ejercicio3(scan);
                    break;
                case 4:
                    Ejercicio4(scan);
                    break;
                case 5:
                    Ejercicio5(scan);
                    break;
            }

            System.out.println(">>>Si desea continuar probando ejercicios presione 1");
            continuar = scan.nextInt();

        }while (continuar == 1);
        scan.close();
    }

    public static void Ejercicio2(Scanner scan) throws Exception{
        System.out.println(separador);
        System.out.println("Ejercicio2: Ingrese 3 valores y se mostraran por pantalla");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
 
        System.out.println("El primer nro ingresado es: " + a);
        System.out.println("El primer nro ingresado es: " + b);
        System.out.println("El primer nro ingresado es: " + c);
 
    }

    public static void Ejercicio3(Scanner scan) throws Exception {
        System.out.println(separador);
        System.out.println("Ejercicio3: Ingrese una calificacion y la interpreto");
        int nota = scan.nextInt();

        if (nota > 92){
            System.out.println("Excelente");
        }else if (nota > 84){
            System.out.println("Sobresaliente");
        } else if (nota > 74){
            System.out.println("Distinguido");
        } else if (nota > 59){
            System.out.println("Bueno");
        } else {
            System.out.println("Desaprobado");
        }
    }

    public static void Ejercicio4(Scanner scan) throws Exception {
        System.out.println(separador);
        System.out.println("Ejercicio5: Ingrese un numero y lo relaciono con un día");
        int dia = scan.nextInt();

        switch(dia){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Lunes");
                break;
            case 3:
                System.out.println("Martes");
                break;
            case 4:
                System.out.println("Miercoles");
                break;
            case 5:
                System.out.println("Jueves");
                break;
            case 6:
                System.out.println("Viernes");
                break;
            case 7:
                System.out.println("Sabado");
                break;
        }
    }

    public static void Ejercicio5(Scanner scan) throws Exception {
        System.out.println(separador);
        System.out.println("Ejercicio5: Ingrese un numero y se lo mostrare hasta que quiera");
        int continuar = 1;
        int nro;
        do{
            System.out.println("Por favor, ingrese un número: ");
            nro = scan.nextInt();
            System.out.println("El numero ingresado es" + nro);
            
            System.out.println("Si desea presione ingresar más coloque 1, sino otro valor");
            continuar = scan.nextInt();
        } while (continuar == 1);
    }
}