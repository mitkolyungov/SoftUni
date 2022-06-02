import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] integers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();


        String[] command = scanner.nextLine ().split (" ");

        while (!command[0].equals ("end")) {

            if (command[0].equals ("swap")) {
                int indexFirst = Integer.parseInt (command[1]);
                int indexSecond = Integer.parseInt (command[2]);

                swap (integers, indexFirst, indexSecond);
            } else if (command[0].equals ("multiply")) {
                int indexFirst = Integer.parseInt (command[1]);
                int indexSecond = Integer.parseInt (command[2]);

                multiply (integers, indexFirst, indexSecond);
            }else if (command[0].equals ("decrease")){
                decreaseBy1(integers);
            }


            command = scanner.nextLine ().split (" ");
        }

        printArray(integers);
    }

    private static void printArray(int[] integers) {
        for (int i = 0; i < integers.length; i++) {
            if (i<integers.length-1){
                System.out.print(integers[i]+", ");
            }else {
                System.out.print(integers[i]);
            }
        }
    }

    private static void decreaseBy1(int[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i]--;
        }
    }

    private static void multiply(int[] integers, int indexFirst, int indexSecond) {
        integers[indexFirst] = integers[indexFirst] * integers[indexSecond];
    }

    private static void swap(int[] integers, int indexFirst, int indexSecond) {
        int temp = integers[indexFirst];
        integers[indexFirst] = integers[indexSecond];
        integers[indexSecond] = temp;
    }
}
