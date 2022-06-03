import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String type = scanner.nextLine ();

        switch (type) {
            case "int": {
                int first = Integer.parseInt (scanner.nextLine ());
                int second = Integer.parseInt (scanner.nextLine ());
                System.out.println (getMax (first, second));

                break;
            }
            case "char": {
                char first = scanner.nextLine ().charAt (0);
                char second = scanner.nextLine ().charAt (0);
                System.out.println (getMax (first, second));

                break;
            }
            case "string": {
                String first = scanner.nextLine ();
                String second = scanner.nextLine ();
                System.out.println (getMax (first, second));
                break;
            }
        }
    }

    private static int getMax(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    private static char getMax(char first, char second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    private static String getMax(String first, String second) {
        if (first.compareTo (second) > 0) {
            return first;
        }
        return second;
    }


}
