package ejerciciosficheros;

import java.io.*;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class Ejercicio7 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opc = 0;
        TreeMap<String, Integer> agenda = new TreeMap<>();
        try {
            File fichero = new File(".\\src/ficheros/agenda.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (fichero.exists()){
            }
            while (opc != 4){
                opc = menu();
                switch (opc){
                    case 1:
                        String nombre;
                        int telefono, cont = 0;
                        boolean encontrado = false;
                        System.out.println("Introduzca el nombre del nuevo contacto");
                        sc.nextLine();
                        nombre = sc.nextLine();
                        System.out.println("Introduzca el número de teléfono");
                        telefono = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < agenda.size(); i++) {
                            cont++;
                        }
                        if (agenda.containsValue(nombre))
                            encontrado = true;
                        if (!encontrado && cont<20)
                            agenda.put(nombre, telefono);
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del contacto que desea buscar");
                        sc.nextLine();
                        nombre = sc.nextLine();
                        if (agenda.containsKey(nombre))
                            System.out.println("Su teléfono es: " + agenda.get(nombre));
                        break;
                    case 3:
                        System.out.println(agenda);
                        break;
                    case 4:
                        if (!fichero.exists())
                            fichero.createNewFile();
                        System.out.println(agenda);
                        bw.write(String.valueOf(agenda));
                        bw.flush();
                        bw.newLine();
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            sc.close();
        }
    }
    public static int menu(){
        int opc = 0;
        System.out.println("1. Nuevo contacto.\n" +
                "2. Buscar por nombre.\n" +
                "3. Mostrar todo.\n" +
                "4. Salir.");
        opc = sc.nextInt();
        return opc;
    }
}
