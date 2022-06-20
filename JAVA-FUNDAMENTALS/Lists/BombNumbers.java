import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> list = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        int[] bomb = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int bombNumber = bomb[0];
        int power = bomb[1];


        for (int index = 0; index < list.size (); index++) {

            if (list.get (index) == bombNumber) {

                int end = Math.min (index + power, list.size () - 1);

                for (int i = index + 1; i <= end; i++) {
                    list.remove (i);
                    i--;
                    end--;
                }

                int begin = Math.max (index - power, 0);

                for (int i = index; i >= begin; i--) {
                    list.remove (i);
                    index--;
                }
            }
        }

        System.out.println (list.stream ().mapToInt (Integer::intValue)
                .sum ());
    }
}
