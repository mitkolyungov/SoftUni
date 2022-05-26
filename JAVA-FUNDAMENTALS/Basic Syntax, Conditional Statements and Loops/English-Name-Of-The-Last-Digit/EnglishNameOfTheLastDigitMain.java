import java.util.Scanner;

public class EnglishNameOfTheLastDigitMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int number = Integer.parseInt (scanner.nextLine ());

        System.out.println (LastDigitName (number));
    }

    private static String LastDigitName(int number) {
        String string = String.valueOf (number);
        String[] namesOfNumbers = {"zero", "one", "two", "three", "four", "five"
                , "six", "seven", "eight", "nine"};

        return namesOfNumbers[Integer.parseInt
                (String.valueOf (string.charAt (string.length () - 1)))];
    }
}
