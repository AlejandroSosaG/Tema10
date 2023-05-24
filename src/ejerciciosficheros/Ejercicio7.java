package ejerciciosficheros;

import java.io.*;
import java.util.*;
public class Ejercicio7 {
    static Scanner sc;
    public static void main(String[] args) {
        int opc = 0;
        String nombre;
        int telefono;
        TreeMap<String, Integer> agenda = new TreeMap<>();
        try {
            File fichero = new File("src/ficheros/agenda.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            sc = new Scanner(br);
            if (fichero.exists()) {
                while (sc.hasNext()){
                    nombre = sc.next();
                    telefono = sc.nextInt();
                    agenda.put(nombre, telefono);
                }
            } else fichero.createNewFile();
            sc = new Scanner(System.in);
            while (opc != 4) {
                opc = menu();
                switch (opc) {
                    case 1:
                        int cont = 0;
                        boolean encontrado = false;
                        for (int i = 0; i < agenda.size(); i++) {
                            cont++;
                        }
                        if (cont == 20) {
                            System.out.println("No hay espacio para más contactos");
                        } else {
                            System.out.println("Introduzca el nombre del nuevo contacto");
                            sc.nextLine();
                            nombre = sc.nextLine();
                            System.out.println("Introduzca el número de teléfono");
                            telefono = sc.nextInt();
                            sc.nextLine();
                            if (agenda.containsValue(nombre))
                                encontrado = true;
                            if (!encontrado && cont < 20)
                                agenda.put(nombre, telefono);
                        }
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del contacto que desea buscar");
                        sc.nextLine();
                        nombre = sc.nextLine();
                        if (agenda.containsKey(nombre))
                            System.out.println("Su teléfono es: " + agenda.get(nombre));
                        break;
                    case 3:
                        if (agenda.isEmpty()) {
                            System.out.println("La agenda está vacía");
                        } else {
                            for (Map.Entry<String, Integer> entry : agenda.entrySet()) {
                                System.out.println("" + entry.getKey() + " " + entry.getValue());
                            }
                        }
                        break;
                    case 4:
                        FileWriter fw = new FileWriter(fichero, false);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Map.Entry<String, Integer> entry : agenda.entrySet()) {
                            bw.write(("" + entry.getKey() + " " + entry.getValue()));
                            bw.newLine();
                        }
                        bw.flush();
                        bw.close();
                        fw.close();
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }

    public static int menu() {
        int opc;
        System.out.println("1. Nuevo contacto.\n" +
                "2. Buscar por nombre.\n" +
                "3. Mostrar todo.\n" +
                "4. Salir.");
        opc = sc.nextInt();
        return opc;
    }
}
