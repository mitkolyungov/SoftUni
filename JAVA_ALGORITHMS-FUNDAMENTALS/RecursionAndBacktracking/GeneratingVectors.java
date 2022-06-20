import java.util.Scanner;

public class GeneratingVectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        int[] vectors = new int[n];

        generateVectors (vectors, 0);
    }

    private static void generateVectors(int[] vectors, int index) {
        if (index == vectors.length) {
            print (vectors);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            vectors[index] = i;
            generateVectors (vectors, index + 1);
        }
    }

    private static void print(int[] vectors) {
        for (int vector : vectors) {
            System.out.print (vector);
        }
        System.out.println ();
    }
}
