import java.util.Scanner;

public class App {

    public static String menu = "Seleccione una opcion: 2 ,3, 4, 5";
    public static String separador = "=========================================================";
    public static void main(String[] args) throws Exception {
        System.out.println(separador);
        System.out.println(menu);
        Scanner scan = new Scanner(System.in);
        int continuar = 1;
        do{
            int opcion = scan.nextInt();
            switch (opcion){
                case 2:
                    Ejercicio2();
                    break;
                case 3:
                    Ejercicio3();
                    break;
                case 4:
                    Ejercicio4();
                    break;
                case 5:
                    Ejercicio5();
                    break;
            }

            System.out.println("Si desea presione 1, sino otro valor");
            continuar = scan.nextInt();

        }while (continuar == 1);
        scan.close();
    }

    public static void Ejercicio2(){
        Scanner scan = new Scanner(System.in);
        System.out.println(separador);
        System.out.println("Ejercicio2: Ingrese 3 valores y se mostraran por pantalla");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
 
        System.out.println("El primer nro ingresado es: " + a);
        System.out.println("El primer nro ingresado es: " + b);
        System.out.println("El primer nro ingresado es: " + c);
 
         scan.close();
    }

    public static void Ejercicio3() throws Exception {
        System.out.println(separador);
        System.out.println("Ejercicio3: Ingrese una calificacion y la interpreto");
        Scanner scan = new Scanner (System.in);
        int nota = scan.nextInt();
        scan.close();
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

    public static void Ejercicio4() throws Exception {
        System.out.println(separador);
        System.out.println("Ejercicio5: Ingrese un numero y lo relaciono con un día");
        Scanner scan = new Scanner (System.in);
        int dia = scan.nextInt();
        scan.close();

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

    public static void Ejercicio5() throws Exception {
        System.out.println(separador);
        System.out.println("Ejercicio5: Ingrese un numero y se lo mostrare hasta que quiera");
        Scanner scan = new Scanner(System.in);
        int continuar = 1;
        int nro;
        do{
            System.out.println("Por favor, ingrese un número: ");
            nro = scan.nextInt();
            System.out.println("El numero ingresado es" + nro);
            
            System.out.println("Si desea presione 1, sino otro valor");
            continuar = scan.nextInt();
        } while (continuar == 1);
        scan.close();
    }
}