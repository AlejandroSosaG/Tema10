package ejerciciosficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int cont = 0;
        int media = 0;
        Scanner sc = null;
        try {
            File fichero = new File(".\\src/ficheros/Enteros.txt");
            FileReader fr = new FileReader(fichero);
            sc = new Scanner(fr);
            while (sc.hasNext()){
                media += sc.nextInt();
                cont++;
            }
            System.out.println("Suma =  " + media);
            media /= cont ;
            System.out.println("Media = " + media);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
}
