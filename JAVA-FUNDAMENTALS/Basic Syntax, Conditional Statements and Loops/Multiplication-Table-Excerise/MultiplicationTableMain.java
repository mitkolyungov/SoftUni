import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationTableMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        int n = Integer.parseInt (input.readLine ());
        int multiplier = Integer.parseInt (input.readLine ());
        for (int i = multiplier; i <= 10; i++) {
            System.out.printf ("%d X %d = %d\n",n,i,n*i);
        }
        if (multiplier>10){
            System.out.printf ("%d X %d = %d\n",n,multiplier,n*multiplier);
        }
    }
}
