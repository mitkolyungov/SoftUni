import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        final double EPS = 0.000001;

        double number1 = Double.parseDouble (scanner.nextLine ());
        double number2 = Double.parseDouble (scanner.nextLine ());

        double difference = Math.abs (number1-number2);
        if (difference>EPS){
            System.out.println ("False");
        }else if (difference<=EPS){
            System.out.println ("True");
        }

    }
}
