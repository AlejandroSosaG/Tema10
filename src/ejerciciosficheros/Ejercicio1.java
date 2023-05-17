package ejerciciosficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        double cont = 0;
        double media = 0;
        Scanner sc = null;
        try {
            File fichero = new File(".\\src/ficheros/NumerosReales.txt");
            FileReader fr = new FileReader(fichero);
            sc = new Scanner(fr);
            while (sc.hasNext()){
                media += sc.nextDouble();
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
