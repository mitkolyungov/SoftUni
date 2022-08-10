import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Pattern pattern = Pattern.compile ("([@#]+)(?<color>[a-z]+)[@#]+([^a-zA-Z\\d]*)(/)+(?<number>\\d+)(/)+");
        Matcher matcher = pattern.matcher (scanner.nextLine ());

        while (matcher.find ()) {

            if (matcher.group ("color").length () >= 3 && onlyLowerCase(matcher.group ("color"))) {
                System.out.printf ("You found %s %s eggs!%n",matcher.group ("number"),matcher.group ("color"));
            }
        }

    }

    private static boolean onlyLowerCase(String group) {
        for (int i = 0; i < group.length (); i++) {
            if (Character.isAlphabetic (group.charAt (i))){
                if (Character.isUpperCase (group.charAt (i))){
                    return false;
                }
            }
        }
        return true;
    }
}
