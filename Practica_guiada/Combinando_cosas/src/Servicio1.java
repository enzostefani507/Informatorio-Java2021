public class Servicio1 {

    public static String bienvenida = "Bienvenido";
    public static void main(String[] args) throws Exception {
        System.out.println(bienvenida);
        /*
        Comentario
        */
        String hola = "Hola";
        ImprimirTextoVeces(hola,3);
    }

    public static void ImprimirTextoVeces(String texto, int contador){
        for (int i = 0; i < contador ; i++){
            System.out.println(texto);
        }
    }
}
