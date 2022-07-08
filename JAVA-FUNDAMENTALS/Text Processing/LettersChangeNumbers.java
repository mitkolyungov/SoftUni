import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] strings = scanner.nextLine ().split ("\\s+");
        double totalSum = 0;

        for (String gameData : strings) {
            String[] letters = gameData.split ("\\d+");
            double number = Double.parseDouble (gameData.substring (1, gameData.length () - 1));

            if (Character.isUpperCase (letters[0].charAt (0))) {
                number /= letters[0].charAt (0) - 'A' + 1;
            } else if (Character.isLowerCase (letters[0].charAt (0))) {
                number *= letters[0].charAt (0) - 'a' + 1;
            }

            if (Character.isUpperCase (letters[1].charAt (0))) {
                number -= letters[1].charAt (0) - 'A' + 1;
            } else if (Character.isLowerCase (letters[1].charAt (0))) {
                number += letters[1].charAt (0) - 'a' + 1;
            }

            totalSum += number;

        }
        System.out.printf ("%.2f", totalSum);

    }
}
