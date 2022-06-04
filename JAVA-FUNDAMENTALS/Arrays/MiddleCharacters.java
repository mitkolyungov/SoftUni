import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String string = scanner.nextLine ();

        middleCharacters(string);
    }

    private static void middleCharacters(String string) {
        if (string.length ()%2==0){
            int middle = string.length ()/2;
            System.out.println (string.substring (middle-1,middle+1));
        }else {
            System.out.println (string.charAt (string.length ()/2));
        }
    }
}
