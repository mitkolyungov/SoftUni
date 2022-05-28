import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int start = Integer.parseInt (scanner.nextLine ());
        int end = scanner.nextInt ();

        for (int i = start; i <=end; i++) {
            char symbol = (char) i;
            System.out.print(symbol+" ");
        }

    }
}

