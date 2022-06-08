import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int[] holderLen = new int[numbers.length];
        int[] previous = new int[numbers.length];

        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            holderLen[i] = 1;
            previous[i] = -1;

            for (int k = 0; k < i; k++) {
                if (numbers[k] < numbers[i] && holderLen[k] + 1 > holderLen[i]) {
                    holderLen[i] = holderLen[k] + 1;
                    previous[i] = k;
                }
            }

            if (holderLen[i] > maxLength) {
                maxLength = holderLen[i];
                lastIndex = i;
            }
        }

        int[] resultArray = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1) {
            resultArray[currentIndex] = numbers[lastIndex];
            currentIndex--;
            lastIndex = previous[lastIndex];
        }

        for (int number : resultArray) {
            System.out.print (number + " ");
        }

    }
}
