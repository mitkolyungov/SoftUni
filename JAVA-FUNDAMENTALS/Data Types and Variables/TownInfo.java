import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] data = new String[3];
        for (int i = 0; i < 3; i++) {
            data[i] = scanner.nextLine ();
        }

        System.out.printf("Town %s has population of %s and area %s square km."
        ,data[0],data[1],data[2]);
    }
}
