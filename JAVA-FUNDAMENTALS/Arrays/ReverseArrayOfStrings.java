import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String[] array = scanner.nextLine ().split ("\\s+");

        for (int i = 0; i < array.length/2; i++) {
            String temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }

        for (String s : array) {
            System.out.print (s + " ");
        }
    }
}
