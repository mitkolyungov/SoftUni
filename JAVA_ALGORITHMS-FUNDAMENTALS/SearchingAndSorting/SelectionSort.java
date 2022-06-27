public class SelectionSort {
    public static void main(String[] args) {

        int[] integers = {1, 3, 5, 6, 8, 9, 2, 4};

        selectionSort (integers);

        for (int integer : integers) {
            System.out.print (integer + " ");
        }
    }

    private static void selectionSort(int[] integers) {
        for (int index = 0; index < integers.length; index++) {
            int min = index;
            for (int curr = index; curr < integers.length; curr++) {
                if (integers[curr] < integers[min]) {
                    min = curr;
                }
            }
            swap (integers, index, min);
        }
    }

    private static void swap(int[] integers, int index, int min) {
        int temp = integers[index];
        integers[index] = integers[min];
        integers[min] = temp;
    }
}
