public class Calculadora {
    /* 
    This class is for math operations
    */
    public static void main(String[] args) throws Exception {
        System.out.println(factorial(5));
        System.out.println(sum(2,3));
    }

    public static int sum(int num1, int num2){
        return num1+num2;
    }

    public static int factorial(int numero){
        int res = numero;
        if (numero != 1){
            res = res*factorial(numero-1);
        }
        return res;
    }
}
