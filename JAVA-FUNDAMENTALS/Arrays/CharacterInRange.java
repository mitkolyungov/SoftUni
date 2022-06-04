import java.util.Scanner;

public class CharacterInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        char first = scanner.nextLine ().charAt (0);
        char second = scanner.nextLine ().charAt (0);

        if (first > second) {
            char temp = first;
            first = second;
            second = temp;
        }

        range (first, second);
    }

    private static void range(char first, char second) {
        for (char start = first; start < second; start++) {
            if (start == first) {
                continue;
            }
            System.out.print (start + " ");
        }
    }
}
