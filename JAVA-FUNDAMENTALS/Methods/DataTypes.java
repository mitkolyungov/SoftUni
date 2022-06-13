import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String type = scanner.nextLine ();

        dataType (type, scanner);


    }

    private static void dataType(String type, Scanner scanner) {
        switch (type) {
            case "int":
                int integer = Integer.parseInt (scanner.nextLine ());
                System.out.println (integer * 2);
                break;
            case "real":
                double d = Double.parseDouble (scanner.nextLine ());
                System.out.printf ("%.2f", d * 1.5);
                break;
            case "string":
                String string = (scanner.nextLine ());
                System.out.printf ("$%s$", string);
                break;
        }
    }
}
