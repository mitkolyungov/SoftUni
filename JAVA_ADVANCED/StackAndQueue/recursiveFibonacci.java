import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class recursiveFibonacci {
    static long[] storage;
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<> ();

        int number = Integer.parseInt (scanner.nextLine ());
        storage = new long[number+1];


        System.out.printf("%d",fibonacci (number));
    }

    private static long fibonacci(int number) {
        if (number<=1){
            return 1;
        }
        if (storage[number]!=0){
            return storage[number];
        }

        long result =  fibonacci (number-1)+fibonacci (number-2);
        storage[number] = result;
        return result;
    }
}
