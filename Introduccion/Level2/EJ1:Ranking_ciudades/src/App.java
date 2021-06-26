public class App {
    public static void main(String[] args) throws Exception {
        String [] ciudades = {"Bariloche", "Córdoba", "Resistencia"};

        for (int i = 1; i < ciudades.length+1; i++ ){
            System.out.println("#"+i+" - "+ciudades[i-1]);
        }
    }
}
