public class ServicioSueldo {
    public static void main(String[] args){
        Empleado e1 = new EmpleadoEfectivo(123123,"Enzo","Toledo",40000,2);
        Empleado e2 = new EmpleadoJornada(123123,"Maura","Sotelo",100,400);
        System.out.println(e1.calcularSueldo());
        System.out.println(e2.calcularSueldo());
    }
}
