import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] intArray = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        System.out.println (findSum (intArray, 0));
    }

    private static int findSum(int[] intArray, int index) {
        if (index == intArray.length) {
            return 0;
        }
        return intArray[index] + findSum (intArray, index + 1);
    }
}
