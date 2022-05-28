import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        if (Character.isUpperCase (scanner.nextLine ().charAt (0))){
            System.out.println ("upper-case");
        }else {
            System.out.println ("lower-case");
        }
    }
}


