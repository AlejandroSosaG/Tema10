package ejerciciosficheros;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int opc = 0;
        Scanner sc = new Scanner(System.in);
        while (opc != 3){
            System.out.println("1. Registra nueva temperatura.\n" +
                    "2. Mostrar historial de registros.\n" +
                    "3. Salir.");
            opc = sc.nextInt();
            switch (opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
