import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int waterTankCapacity = 255;
        int n = Integer.parseInt (scanner.nextLine ());
        int totalLitters = 0;
        for (int i = 0; i < n; i++) {
            int litters = scanner.nextInt ();

            totalLitters+= litters;

            if (totalLitters>waterTankCapacity){
                System.out.println ("Insufficient capacity!");
                totalLitters-=litters;
            }
        }
        System.out.println (totalLitters);

    }
}
