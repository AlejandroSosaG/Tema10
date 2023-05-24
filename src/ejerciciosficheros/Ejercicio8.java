package ejerciciosficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio8 {
    static Scanner sc;
    static File fichero = new File("src/ficheros/Temperaturas.txt");
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int opc = 0;
        while (opc != 3){
            sc = new Scanner(System.in);
            System.out.println("1. Registra nueva temperatura.\n" +
                    "2. Mostrar historial de registros.\n" +
                    "3. Salir.");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc){
                case 1:
                    nuevoRegistro();
                    break;
                case 2:
                    historial();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
    public static void nuevoRegistro(){
        String fecha;
        double max, min;
        try {
            if (!fichero.exists())
                fichero.createNewFile();
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Introduzca la fecha");
            fecha = sc.next();
            sc.nextLine();
            System.out.println("Introduzca la temperatura máxima");
            max = sc.nextDouble();
            sc.nextLine();
            System.out.println("Introduzca la temperatura mínima");
            min = sc.nextDouble();
            sc.nextLine();
            bw.write(fecha + "," + max + "," + min);
            bw.flush();
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void historial(){
        String cabecera, linea;
        String[] info;
        double max = 0, min = 999999999;
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            sc = new Scanner(br);
            cabecera = sc.nextLine();
            System.out.println(cabecera);
            while (sc.hasNext()){
                linea = sc.nextLine();
                info = linea.split(",");
                System.out.println(info[0] + "," + info[1] + "," + info[2]);
                if (Double.parseDouble(info[1]) > max)
                    max = Double.parseDouble(info[1]);
                if (Double.parseDouble(info[2]) < min)
                    min = Double.parseDouble(info[2]);
            }
            System.out.println("Temperatura MÁXIMA: " + max);
            System.out.println("Temperatura MÍNIMA: " + min);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
