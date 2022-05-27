import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int decimalNumber = Integer.parseInt (scanner.nextLine ());

        ArrayDeque<Integer> binaryNumber  = new ArrayDeque<> ();

        if (decimalNumber==0){
            System.out.println (decimalNumber);
            return;
        }

        while (decimalNumber!=0){
            int binary = decimalNumber%2;
            binaryNumber.push (binary);
            decimalNumber = decimalNumber/2;
        }

        for (Integer integer : binaryNumber) {
            System.out.print(binaryNumber.pop ());
        }
    }
}
