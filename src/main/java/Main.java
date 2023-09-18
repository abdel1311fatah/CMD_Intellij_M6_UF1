import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Microsoft Windows [Versión 10.0.22621.2283]\n" +
                "(c) Microsoft Corporation. Todos los derechos reservados.");
        System.out.println("\t Utilitzar amb rutes absolutes si no no va \t");
        String option = null;
        File file = new File("C:\\Users\\abel1");
        File oldFile = null; // Per a que pilli be la ruta si falle al mkdir o al cd

        do {

            Scanner scan = new Scanner(System.in);

            System.out.print(file + " ");
            option = scan.nextLine();

            String[] separator = option.split("\\s");


            if(!option.equalsIgnoreCase("cd")) {
                if (separator[0].equalsIgnoreCase("cd") || (option.equalsIgnoreCase("cd"))) {
                    file = new File(separator[1]);
                    if (!file.exists()) {
                        System.out.println("El sistema no puede encontrar la ruta especificada.");
                        file = new File("C:\\Users\\abel1");
                    }
                }
            }

            if(!option.equalsIgnoreCase("mkdir")) {
                if (separator[0].equalsIgnoreCase("mkdir") || (option.equalsIgnoreCase("mkdir"))) {
                    oldFile = file;
                    file = new File(separator[1]);
                    if (!file.exists()) {
                        if (!file.mkdirs()) { // El mkdirs retorne true si s ha pogut crear el directori i fals si no
                            System.out.println("Error al crear directorios");
                            file = oldFile;
                        }else{
                            System.out.println("Directorio creado correctamente");
                        }
                    }else{
                        System.out.println("Ya existe el subdirectorio o el archivo "+ file);
                        file = oldFile;
                    }
                }
            }

            if(!option.equalsIgnoreCase("dir")) {
                if (separator[0].equalsIgnoreCase("dir") || (option.equalsIgnoreCase("dir"))) {
                    file = new File(separator[1]);
                    if (!file.exists()) {
                        System.out.println("El sistema no puede encontrar la ruta especificada.");
                    }else{
                        File [] llista = file.listFiles();
                        for (File nom : llista) {
                            Date data = new Date(nom.lastModified());
                            System.out.println(nom.getName() + " " + nom.length() + " bytes aqnd the last modification was at: " + data);
                        }
                    }
                }
            }

            if(!option.equalsIgnoreCase("del")) {
                if (separator[0].equalsIgnoreCase("del") || (option.equalsIgnoreCase("del"))) {
                    oldFile = file;
                    file = new File(separator[1]);
                    if (file.exists()) {
                        if(file.delete()) { // true si es pot borrar false si no
                            file = new File("C:\\Users\\abel1");
                        }else{
                            System.out.println("No se puede borrar el subdirectorio o el archivo "+ file);
                            file = oldFile;
                        }
                    }else{
                        System.out.println("No existe un subdirectorio o el archivo "+ file);
                        file = oldFile;
                    }
                }
            }

        } while (!option.equalsIgnoreCase("exit"));

    }

}
