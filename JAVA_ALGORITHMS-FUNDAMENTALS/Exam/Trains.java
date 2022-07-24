import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Trains {

    public static void main(String[] args){

        //  2.00 2.10 3.00 3.20 3.50 5.00
        // 2.30 3.40 3.20 4.30 4.00 5.20

        // 14.00 14.10 00.40 14.10 1.50
        //  14.50 14.40 23.50 14.20 2.00

        Scanner scanner = new Scanner(System.in);
        double[] arrd = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        int[] arr = new int[arrd.length];
        for (int i = 0; i < arrd.length; i++) {
            arr[i] = (int) (arrd[i]*100);

        }

        double[] depd = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        int[] dep = new int[depd.length];
        for (int i = 0; i < depd.length; i++) {

            dep[i] = (int) (depd[i] * 100);



        }





        // int arr[] = { 200, 210, 300, 320, 350, 500};
        //int dep[] = { 230, 340, 320, 430, 400, 520 };

        int n = arr.length;
        System.out.println(findPlatform(arr, dep, n));

    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        int[][] arr2 = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr2[i] = new int[] { arr[i], dep[i] };
        }
        Arrays.sort(arr2,
                (A, B) -> { return A[0] - B[0]; });


        PriorityQueue<Integer> p = new PriorityQueue<>();
        int count =1;
        p.add(arr2[0][1]);

        for (int i = 1; i < n; i++) {

            int peek = p.peek ();

            if (peek > arr2[i][0]) {
                count++;
            }
            else {
                p.remove();
            }
            p.add(arr2[i][1]);
        }


        return count;

    }
}
