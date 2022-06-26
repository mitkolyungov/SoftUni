import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        arr = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();


        reverseArray (0);
    }

    private static void reverseArray(int index) {
        if (index == arr.length) {
            return;
        }

        reverseArray (index + 1);
        System.out.print (arr[index] + " ");
    }
}
