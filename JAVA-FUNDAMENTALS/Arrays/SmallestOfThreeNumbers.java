import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n1 = Integer.parseInt (scanner.nextLine ());
        int n2 = Integer.parseInt (scanner.nextLine ());
        int n3 = Integer.parseInt (scanner.nextLine ());


        System.out.println (smallestNum (n1, n2, n3));
    }

    private static int smallestNum(int n1, int n2, int n3) {
        if (n1 <= n2 && n2 <= n3) {
            return n1;
        } else if (n2 <= n1 && n1 <= n3) {
            return n2;
        }
        return n3;
    }
}
