package ejercicios.ejercicio2;

public class Main {
    public static void main(String[] args) {
        try {
            Hora hora = new Hora(1,1,1);
            hora.setHora(2);
            hora.setMinuto(2);
            hora.setSegundo(-2);
        }catch (NegativeHourException e){
            System.out.println(e.toString());
        }catch (NegativeMinuteException e){
            System.out.println(e.toString());
        }catch (NegativeSecondException e){
            System.out.println(e.toString());
        }
    }
}
