import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String number = scanner.nextLine ();
        int sum = 0;
        for (int i = 0; i < number.length (); i++) {
            sum+=(number.charAt (i)-'0');
        }

        System.out.println (sum);
    }
}
