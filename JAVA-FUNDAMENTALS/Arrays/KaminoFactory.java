import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int lengthSequence = Integer.parseInt (scanner.nextLine ());

        int longestSequence = 0;
        int longestIndex = 0;
        int bestIteration = 1;
        int iteration = 1;
        int maxSum = 0;

        int[] bestArray = new int[lengthSequence];

        String inout = scanner.nextLine ();
        while (!inout.equals ("Clone them!")) {
            int[] numbersDNA = Arrays.stream (inout.split ("!+")).mapToInt (Integer::parseInt).toArray ();

            int currentSequence = 0;
            int currentIndex = 0;
            int totalSum = calculateSumArray (numbersDNA);

            for (int i = 0; i < numbersDNA.length; i++) {
                int number = (numbersDNA[i]);

                if (number == 1) {
                    currentSequence++;

                    if (currentSequence > longestSequence) {

                        longestSequence = currentSequence;
                        longestIndex = currentIndex;
                        maxSum = totalSum;
                        bestIteration = iteration;
                        bestArray = numbersDNA;

                    } else if (currentSequence == longestSequence && currentIndex < longestIndex) {

                        longestIndex = currentIndex;
                        bestIteration = iteration;
                        bestArray = numbersDNA;
                        maxSum = totalSum;

                    } else if (currentSequence == longestSequence && totalSum > maxSum) {
                        longestIndex = currentIndex;
                        bestArray = numbersDNA;
                        bestIteration = iteration;
                        maxSum = totalSum;
                    }

                } else {
                    currentSequence = 0;
                    currentIndex = i + 1;
                }
            }

            iteration++;
            inout = scanner.nextLine ();
        }

        System.out.printf ("Best DNA sample %d with sum: %d.\n", bestIteration, maxSum);
        printArray (bestArray);
    }

    private static void printArray(int[] array) {
        for (int number : array) {
            System.out.print (number + " ");
        }
    }

    private static int calculateSumArray(int[] array) {
        int sum = 0;
        for (int integer : array) {
            if (integer == 1) {
                sum += integer;
            }
        }
        return sum;
    }
}
