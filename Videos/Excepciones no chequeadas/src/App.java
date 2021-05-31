public class App {
    public static void main(String[] args) throws Exception {
        
        try{
            int[] dnis = new int[]{12312, 123123, 12312};
            imprimirCuartoElemento(dnis);

            Integer horasTrabajadasEnMes =2 ;   
            Integer diasTrabajados = 1;
            System.out.println("El promedio de horas trabajadas del empleado es: "
                + horasTrabajadasEnMes/diasTrabajados + "por dia"
            );
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void imprimirCuartoElemento(int[] array){
        System.out.println("Este es el 4to elemento: "+ array[3]);
    }
}
