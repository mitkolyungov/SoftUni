import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());

        String commands = scanner.nextLine ();


        while (!commands.equals ("end")) {
            String[] tokens = commands.split (" ");
            String command = tokens[0];

            switch (command) {
                case "Contains": {
                    int number = Integer.parseInt (tokens[1]);
                    doesNumberExist (numbers, number);
                    break;
                }
                case "Print":
                    String typeNumbers = tokens[1];
                    if (typeNumbers.equals ("even")) {
                        printEven (numbers);
                    } else if (typeNumbers.equals ("odd")) {
                        printOdd (numbers);
                    }
                    break;
                case "Get":
                    getSum (numbers);
                    break;
                case "Filter": {
                    String op = tokens[1];
                    int number = Integer.parseInt (tokens[2]);
                    filter (numbers, op, number);
                    break;
                }
            }

            commands = scanner.nextLine ();
        }
    }

    private static void filter(List<Integer> numbers, String op, int number) {
        List<Integer> filtered = new ArrayList<> ();
        switch (op) {
            case "<": {
                filtered = numbers.stream ().filter (n -> n < number).collect (Collectors.toList ());
                break;
            }
            case "<=": {
                filtered = numbers.stream ().filter (n -> n <= number).collect (Collectors.toList ());
                break;
            }
            case ">": {
                filtered = numbers.stream ().filter (n -> n > number).collect (Collectors.toList ());
                break;
            }
            case ">=": {
                filtered = numbers.stream ().filter (n -> n >= number).collect (Collectors.toList ());
                break;
            }
        }
        filtered.forEach (n -> {
            System.out.print (n + " ");
        });
        System.out.println ();
    }

    private static void doesNumberExist(List<Integer> numbers, int number) {
        if (numbers.contains (number)) {
            System.out.println ("Yes");
        } else {
            System.out.println ("No such number");
        }
    }

    private static void getSum(List<Integer> numbers) {
        System.out.println ((Integer) numbers.stream ()
                .mapToInt (Integer::intValue).sum ());
    }

    private static void printOdd(List<Integer> numbers) {
        numbers.stream ().filter (n -> n % 2 == 1)
                .forEach (n -> {
                    System.out.print (n + " ");
                });
        System.out.println ();
    }

    private static void printEven(List<Integer> numbers) {
        numbers.stream ().filter (n -> n % 2 == 0)
                .forEach (n -> {
                    System.out.print (n + " ");
                });
        System.out.println ();
    }
}
