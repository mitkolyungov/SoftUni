import java.util.*;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] array = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        String commands = scanner.nextLine ();

        while (!commands.equals ("end")) {
            String[] tokens = commands.split (" ");
            String command = tokens[0];
            switch (command) {
                case "exchange": {
                    int index = Integer.parseInt (tokens[1]);
                    if (index < 0 || index >= array.length) {
                        System.out.println ("Invalid index");
                    } else {
                        exchange (array, index);
                    }

                    break;
                }
                case "max": {
                    String evenOrOdd = tokens[1];
                    if (evenOrOdd.equals ("even")) {
                        findMaxEven (array);
                    } else if (evenOrOdd.equals ("odd")) {
                        findMaxOdd (array);
                    }
                    break;
                }
                case "min": {
                    String evenOrOdd = tokens[1];
                    if (evenOrOdd.equals ("even")) {
                        findMinEven (array);
                    } else if (evenOrOdd.equals ("odd")) {
                        findMinOdd (array);
                    }
                    break;
                }
                case "first": {
                    int count = Integer.parseInt (tokens[1]);
                    String evenOrOdd = tokens[2];
                    if (evenOrOdd.equals ("even")) {
                        findFirstCountEvenNumbers (array, count);
                    } else if (evenOrOdd.equals ("odd")) {
                        findFirstCountOddNumbers (array, count);
                    }
                    break;
                }
                case "last": {
                    int count = Integer.parseInt (tokens[1]);
                    String evenOrOdd = tokens[2];
                    if (evenOrOdd.equals ("even")) {
                        findLastCountEvenNumbers (array, count);
                    } else if (evenOrOdd.equals ("odd")) {
                        findLastCountOddNumbers (array, count);
                    }
                    break;
                }
            }
            commands = scanner.nextLine ();
        }

        System.out.println (Arrays.toString (array));
    }

    private static void findLastCountOddNumbers(int[] array, int count) {
        if (isCountGreaterEqualTo (array, count)) {
            System.out.println ("Invalid count");
        } else {
            List<Integer> result = new ArrayList<> ();
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] % 2 == 1) {
                    result.add (array[i]);
                }
                if (result.size () == count) {
                    break;
                }
            }
            Collections.reverse (result);
            System.out.println (Arrays.toString (result.toArray ()));
        }
    }

    private static void findLastCountEvenNumbers(int[] array, int count) {
        if (isCountGreaterEqualTo (array, count)) {
            System.out.println ("Invalid count");
        } else {
            List<Integer> result = new ArrayList<> ();
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] % 2 == 0) {
                    result.add (array[i]);
                }
                if (result.size () == count) {
                    break;
                }
            }
            Collections.reverse (result);
            System.out.println (Arrays.toString (result.toArray ()));
        }
    }

    private static void findFirstCountOddNumbers(int[] array, int count) {
        if (isCountGreaterEqualTo (array, count)) {
            System.out.println ("Invalid count");
        } else {
            List<Integer> result = new ArrayList<> ();
            for (int element : array) {
                if (element % 2 == 1) {
                    result.add (element);
                }
                if (result.size () == count) {
                    break;
                }
            }

            System.out.println (Arrays.toString (result.toArray ()));
        }
    }

    private static void findFirstCountEvenNumbers(int[] array, int count) {
        if (isCountGreaterEqualTo (array, count)) {
            System.out.println ("Invalid count");
        } else {
            List<Integer> result = new ArrayList<> ();
            for (int element : array) {
                if (element % 2 == 0) {
                    result.add (element);
                }
                if (result.size () == count) {
                    break;
                }
            }

            System.out.println (Arrays.toString (result.toArray ()));
        }
    }


    private static void findMaxOdd(int[] array) {
        int min = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (min <= array[i] && array[i] % 2 == 1) {
                min = array[i];
                index = i;
            }
        }


        isIndexMatched (index);
    }

    private static void findMaxEven(int[] array) {
        int min = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (min <= array[i] && array[i] % 2 == 0) {
                min = array[i];
                index = i;
            }
        }

        isIndexMatched (index);
    }

    private static void findMinOdd(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (min >= array[i] && array[i] % 2 == 1) {
                min = array[i];
                index = i;
            }
        }

        isIndexMatched (index);
    }

    private static void findMinEven(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (min >= array[i] && array[i] % 2 == 0) {
                min = array[i];
                index = i;
            }
        }

        isIndexMatched (index);
    }

    private static void isIndexMatched(int index) {
        if (index == -1) {
            System.out.println ("No matches");
        } else {
            System.out.println (index);
        }
    }

    private static void exchange(int[] array, int index) {
        int[] temp = Arrays.copyOf (array, array.length);
        int count = 0;

        for (int i = index + 1; i < temp.length; i++) {
            array[count++] = temp[i];
        }

        for (int i = 0; i <= index; i++) {
            array[count++] = temp[i];
        }
    }

    private static boolean isCountGreaterEqualTo(int[] array, int count) {
        return count > array.length;
    }

}
