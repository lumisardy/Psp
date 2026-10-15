import java.util.Scanner;

public class ContadorPrimos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long ini = scanner.nextLong();
        long fin = scanner.nextLong();

        int nPrimos = contarPrimos(ini, fin);

        System.out.println(nPrimos);

    }

    public static int contarPrimos(long ini, long fin) {

        int contador = 0;

        for (long i = ini; i <= fin; i++) {

            if (esPrimo(i))
                contador++;

        }

        return contador;

    }

    public static boolean esPrimo(long num) {

        if (num < 2) {
            return false;
        }

        for (long i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }

}
