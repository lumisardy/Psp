
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ServidorBloqueante {
    public static void main(String[] args) throws IOException, InterruptedException {

        int peticiones = 5;

        Process[] procesos = new Process[peticiones];

        Random random = new Random();

        for (int i = 1; i <= peticiones; i++) {

            int numeroAlea = random.nextInt(5) + 1;

            String peticion = "Peticion- " + numeroAlea;

            String classpath = System.getProperty("java.class.path");
            ProcessBuilder proceso = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    "Trabajador");

            Process pr = proceso.start();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

            bw.write(peticion);
            bw.newLine();

            bw.write(String.valueOf(numeroAlea));
            bw.newLine();

            bw.flush();
            bw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String linea;
            while ((linea = br.readLine()) != null) {

                System.out.println("   " + linea);

            }
            br.close();
            try {
                pr.waitFor();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }

    }

}