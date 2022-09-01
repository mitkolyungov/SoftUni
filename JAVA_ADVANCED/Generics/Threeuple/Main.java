import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] input = scanner.nextLine ().split ("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];
        Tuple<String, String, String> tuple1 = new Tuple<> (name, address, town);
        System.out.println (tuple1);

        input = scanner.nextLine ().split ("\\s+");
        name = input[0];
        int liters = Integer.parseInt (input[1]);
        boolean hasDrunk = input[2].equals ("drunk");
        Tuple<String, Integer, Boolean> tuple2 = new Tuple<> (name, liters, hasDrunk);
        System.out.println (tuple2);

        input = scanner.nextLine ().split ("\\s+");
        name = (input[0]);
        double doublee = Double.parseDouble (input[1]);
        String bankName = input[2];
        Tuple<String, Double, String> tuple3 = new Tuple<> (name, doublee, bankName);
        System.out.println (tuple3);

    }
}
