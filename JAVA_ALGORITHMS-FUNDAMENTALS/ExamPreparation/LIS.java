import java.util.*;

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] sequence = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt)
                .toArray ();

        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        Arrays.fill (prev, -1);

        int maxLength = 0;
        int maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;
            int bestIndex = -1;

            length[i] = bestLength;

            for (int j = i - 1; j >= 0; j--) {
                if (current > sequence[j] && length[j] + 1 >= bestLength) {
                    bestLength = length[j] + 1;
                    bestIndex = j;
                }
            }
            prev[i] = bestIndex;
            length[i] = bestLength;

            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }
        List<Integer> LIS = new ArrayList<> ();

        while (maxIndex != -1) {
            LIS.add (sequence[maxIndex]);
            maxIndex = prev[maxIndex];
        }


        Collections.reverse (LIS);

        for (Integer integer : LIS) {
            System.out.print (integer + " ");
        }
    }
}
