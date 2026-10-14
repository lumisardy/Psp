import java.util.Random;

public class ServidorBloqueante {
    public static void main(String[] args) {


        int peticiones = 5;

        Process[] procesos = new Process[peticiones];

        Random random = new Random();

        for(int i = 1; i <= peticiones ;i++){

            
            int numeroAlea  = random.nextInt(5) +1;

            String peticion = "Peticion- "+numeroAlea; 


            String javapath = System.getProperty("java.")
            ProcessBuilder proceso = new ProcessBuilder()

        }

    }

}