import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int fieldSize = Integer.parseInt (scanner.nextLine ());

        int[] indexesOfLadyBugs = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int[] field = new int[fieldSize];

        for (int indexOfLadyBug : indexesOfLadyBugs) {
            if (indexOfLadyBug >= 0 && indexOfLadyBug < field.length) {
                field[indexOfLadyBug] = 1;
            }
        }

        String command = scanner.nextLine ();

        while (!command.equals ("end")) {
            String[] tokens = command.split (" ");

            int startIndex = Integer.parseInt (tokens[0]);
            if (startIndex < 0 || startIndex >= field.length || field[startIndex] == 0) {
                command = scanner.nextLine ();
                continue;
            }

            String direction = tokens[1];
            int flyLength = Integer.parseInt (tokens[2]);

            field[startIndex] = 0;

            if (direction.equals ("right")) {
                goRight (field, startIndex, flyLength);
            } else if (direction.equals ("left")) {
                goLeft (field, startIndex, flyLength);
            }

            command = scanner.nextLine ();
        }

        printArray (field);
    }

    private static void goLeft(int[] field, int startIndex, int flyLength) {
        while (startIndex - flyLength >= 0 && startIndex - flyLength < field.length) {
            if (field[startIndex - flyLength] == 0) {
                field[startIndex - flyLength] = 1;
                break;
            } else {
                flyLength += flyLength;
            }
        }
    }

    private static void goRight(int[] field, int startIndex, int flyLenght) {
        while (startIndex + flyLenght < field.length && startIndex + flyLenght >= 0) {
            if (field[startIndex + flyLenght] == 0) {
                field[startIndex + flyLenght] = 1;
                break;
            } else {
                flyLenght += flyLenght;
            }
        }
    }


    private static void printArray(int[] array) {
        for (int cell : array) {
            System.out.print (cell + " ");
        }
    }
}
