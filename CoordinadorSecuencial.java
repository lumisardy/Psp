import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CoordinadorSecuencial {
    public static void main(String[] args) throws IOException, InterruptedException {

        long rango = 2000000;

        int nprocesos = 4;
        Process[] procesos = new Process[nprocesos];

        long tiempoIni = System.currentTimeMillis();

        for (int i = 0; i < nprocesos; i++) {

            long tramo = rango / nprocesos;

            long ini = rango * i;
            long fin;

            if (i == nprocesos)
                fin = tramo;
            else
                fin = (i + 1) * tramo;

            String classpath = System.getProperty("java.class.path");
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "ContadorPrimos");
            Process pr = pb.start();
            procesos[i] = pr;

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

            bw.write(String.valueOf(ini));
            bw.newLine();
            bw.write(String.valueOf(fin));
            bw.flush();
            bw.close();

            pr.waitFor();
        }

        int nPrimoTotal = 0;

        for (int i = 0; i < nprocesos; i++) {

            Process pr = procesos[i];
            BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            int nPrimos = Integer.parseInt(br.readLine());

            br.close();

        }

        System.out.println(nPrimoTotal);
        long tiempoFinal = System.currentTimeMillis();

        System.out.println(tiempoFinal - tiempoIni);

    }

}