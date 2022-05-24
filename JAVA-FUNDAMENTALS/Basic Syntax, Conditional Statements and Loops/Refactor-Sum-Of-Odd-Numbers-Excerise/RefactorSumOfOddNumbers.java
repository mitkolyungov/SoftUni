import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        int n = Integer.parseInt (input.readLine ());
        int sum  =0;
        for (int i = 1; i <n*2; i+=2) {
            System.out.println (i);
            sum+=i;
        }
        System.out.println ("Sum: "+ sum);
    }
}
