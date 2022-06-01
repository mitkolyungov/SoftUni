import java.util.*;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine ().split (" ");
            if (i % 2 == 0) {
                firstArray[i] = array[0];
                secondArray[i] = array[1];
            } else {
                firstArray[i] = array[1];
                secondArray[i] = array[0];
            }
        }

        Arrays.stream (firstArray).forEach (s -> {
            System.out.print (s + " ");
        });
        System.out.println ();
        Arrays.stream (secondArray).forEach (s -> {
            System.out.print (s + " ");
        });
    }
}

