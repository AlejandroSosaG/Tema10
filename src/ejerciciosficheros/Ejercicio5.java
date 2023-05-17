package ejerciciosficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        String nombre;
        int edad;
        Scanner sc = new Scanner(System.in);
        try {
            File fichero = new File(".\\src/ficheros/datos.txt");
            FileWriter fr = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fr);
            System.out.println("Introduzca su nombre");
            nombre = sc.nextLine();
            System.out.println("Introduzca su edad");
            edad = sc.nextInt();
            if (!fichero.exists())
                fichero.createNewFile();
            bw.write(nombre + " " + edad);
            bw.flush();
            bw.newLine();
            bw.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
}
