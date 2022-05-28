import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int numberOfSnowBalls = Integer.parseInt (scanner.nextLine ());

        int bestTime = 0;
        int bestQuality = 0;
        int bestSnowBall = 0;
        double highestValue = 0;

        for (int i = 0; i < numberOfSnowBalls; i++) {
            int snowBallSnow = scanner.nextInt ();
            int snowBallTime = scanner.nextInt ();
            int snowBallQuality = scanner.nextInt ();

            double value = Math.pow ((double) snowBallSnow / snowBallTime, snowBallQuality);

            if (value > highestValue) {
                highestValue = value;
                bestTime = snowBallTime;
                bestSnowBall = snowBallSnow;
                bestQuality = snowBallQuality;
            }
        }

        System.out.printf ("%d : %d = %.0f (%d)",bestSnowBall,bestTime,highestValue,bestQuality);


    }
}
