package ejercicios.ejercicio1;

import java.util.*;

public class Utils {
    public static int readInt(Scanner sc){
        int num = 0;
        try {
            num = sc.nextInt();
            sc.nextLine();
        }catch (InputMismatchException e){
            System.out.println("El valor introducido no es un número entero");
        }
        return num;
    }
    public static double readDouble(Scanner sc){
        double num = 0;
        try {
            sc.nextLine();
            num = sc.nextDouble();
            sc.nextLine();
        }catch (InputMismatchException e){
            System.out.println("El valor introducido no es Double");
        }
        return num;
    }
}
