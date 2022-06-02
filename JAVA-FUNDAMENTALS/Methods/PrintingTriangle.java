import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        printTheTriangle (Integer.parseInt (scanner.nextLine ()));
    }

    private static void printTheTriangle(int size) {
        //firstHalf
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print (j + " ");
            }
            System.out.println ();
        }

        //secondHalf
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print (j + " ");
            }
            System.out.println ();
        }
    }
}
