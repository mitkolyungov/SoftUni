import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ForeignLanguageMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        String countryName = input.readLine ();

        Set<String> englishCountries = new HashSet<> ();
        englishCountries.add ("USA");
        englishCountries.add ("England");

        Set<String> spanishCountries = new HashSet<> ();
        spanishCountries.add ("Spain");
        spanishCountries.add ("Argentina");
        spanishCountries.add ("Mexico");

        if (englishCountries.contains (countryName)){
            System.out.println ("English");
        }else if (spanishCountries.contains (countryName)){
            System.out.println ("Spanish");
        }else {
            System.out.println ("unknown");
        }
    }
}
