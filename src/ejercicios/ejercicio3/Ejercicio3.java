package ejercicios.ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            Fecha fecha = new Fecha(1,1,0);
            fecha.setDia(2);
            fecha.setMes(2);
        }catch (DayException e){
            System.out.println(e);
        }catch (MonthException e){
            System.out.println(e);
        }
    }
}
