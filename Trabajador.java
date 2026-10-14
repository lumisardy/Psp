import java.util.Scanner;

public class Trabajador {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String peticion = scanner.nextLine();

        int tiempo = Integer.parseInt(scanner.nextLine());

        try {

            Thread.sleep(tiempo * 1000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Peticion N: " + peticion + " Completada");
        System.out.println("Tiempo total: " + (tiempo * 1000));
        scanner.close();

    }

}
