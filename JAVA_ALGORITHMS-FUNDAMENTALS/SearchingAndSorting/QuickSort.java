import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] arr = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt)
                .toArray ();

        sort (arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        quickSort (arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition (arr, low, high);

            quickSort (arr, low, pi - 1);
            quickSort (arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int leftPointer = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                leftPointer++;

                swap (arr, leftPointer, j);
            }
        }

        swap (arr, leftPointer+1, high);

        return leftPointer + 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
