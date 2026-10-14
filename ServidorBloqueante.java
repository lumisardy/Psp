import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class ServidorBloqueante {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        int numeroPeticiones = Integer.parseInt(scanner.nextLine());

        Random random = new Random();

        long timepoIni = System.currentTimeMillis();

        for (int i = 1; i <= numeroPeticiones; i++) {

            int numeroAle = random.nextInt(5) + 1;

            System.out.println("Peticion- " + i);

            String javaPath = System.getProperty("java.class.path");
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", javaPath, "Trabajador");
            Process pr;
            try {
                pr = pb.start();

                BufferedWriter bfW = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

                bfW.write(i);
                bfW.newLine();
                bfW.write(numeroAle);
                bfW.newLine();
                bfW.flush();
                bfW.close();

                BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));

                String resultado = br.readLine();

                br.close();
                System.out.println(resultado);

                pr.waitFor();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
