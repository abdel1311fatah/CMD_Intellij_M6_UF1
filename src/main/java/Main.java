import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Microsoft Windows [Versión 10.0.22621.2283]\n" +
                "(c) Microsoft Corporation. Todos los derechos reservados.");
        String option = null;
        File file = new File("C:\\Users\\abel1>");

        do {

            Scanner scan = new Scanner(System.in);

            System.out.print(file);
            option = scan.nextLine();

            String[] separator = option.split("\\s");
            if(!option.equalsIgnoreCase("cd")) {
                if (separator[0].equalsIgnoreCase("cd") || (option.equalsIgnoreCase("cd"))) {
                    file = new File(separator[1]);
                    if (!file.exists()) {
                        System.out.println("El sistema no puede encontrar la ruta especificada.");
                    }
                }
            }

        } while (!option.equalsIgnoreCase("exit"));

    }

}
