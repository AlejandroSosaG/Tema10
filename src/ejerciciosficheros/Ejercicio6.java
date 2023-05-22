package ejerciciosficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList();
        Scanner sc = null;
        try {
            File fichero = new File(".\\src/ficheros/numeros.txt");
            File ficheroSalida = new File(".\\src/ficheros/numerosOrdenados.txt");
            FileReader fr = new FileReader(fichero);
            sc = new Scanner(fr);
            FileWriter fw = new FileWriter(ficheroSalida);
            BufferedWriter bw = new BufferedWriter(fw);
            while (sc.hasNext()){
                lista.add(sc.nextInt());
            }
            lista.sort(null);
            if (!ficheroSalida.exists())
                ficheroSalida.createNewFile();
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
                bw.write(lista.get(i));
                bw.flush();
                bw.newLine();
            }
            bw.close();
            fw.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
}
