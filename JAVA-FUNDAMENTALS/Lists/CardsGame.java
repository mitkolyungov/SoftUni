import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> firstPlayerHand = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        List<Integer> secondPlayerHand = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());


        while (firstPlayerHand.size () > 0 && secondPlayerHand.size () > 0) {
            int firstPlayerCard = firstPlayerHand.get (0);
            int secondPlayerCard = secondPlayerHand.get (0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerHand.remove (0);

                firstPlayerHand.add (firstPlayerCard);
                firstPlayerHand.add (secondPlayerCard);

                secondPlayerHand.remove (Integer.valueOf (secondPlayerCard));

            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerHand.remove (0);

                secondPlayerHand.add (secondPlayerCard);
                secondPlayerHand.add (firstPlayerCard);

                firstPlayerHand.remove (Integer.valueOf (firstPlayerCard));

            } else {
                firstPlayerHand.remove (Integer.valueOf (firstPlayerCard));
                secondPlayerHand.remove (Integer.valueOf (secondPlayerCard));
            }
        }

        if (secondPlayerHand.size () == 0) {
            int sum = firstPlayerHand.stream ().mapToInt (Integer::intValue).sum ();

            System.out.printf ("First player wins! Sum: %d", sum);

        } else {
            int sum = secondPlayerHand.stream ().mapToInt (Integer::intValue).sum ();

            System.out.printf ("Second player wins! Sum: %d", sum);
        }
    }
}
