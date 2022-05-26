import java.util.Scanner;

public class ReverseStringMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        StringBuilder stringBuilder = new StringBuilder (scanner.nextLine ());
        System.out.println (stringBuilder.reverse ());
    }
}
