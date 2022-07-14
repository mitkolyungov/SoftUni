import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder ();

        for (String url : urls) {
            if (validUrl (url) && !url.trim ().equals ("")) {
                stringBuilder.append (String.format ("Browsing: %s%n", url));
            } else {
                stringBuilder.append ("Invalid URL!")
                        .append (System.lineSeparator ());
            }
        }
        return stringBuilder.toString ().trim ();
    }

    private boolean validUrl(String url) {
        for (int i = 0; i < url.length (); i++) {
            if (Character.isDigit (url.charAt (i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder ();

        for (String number : numbers) {
            if (hasOnlyNumbers (number) && !number.trim ().equals ("")) {
                stringBuilder.append (String.format ("Calling... %s%n", number));

            } else {
                stringBuilder.append ("Invalid number!")
                        .append (System.lineSeparator ());
            }
        }
        return stringBuilder.toString ().trim ();
    }

    private boolean hasOnlyNumbers(String number) {
        for (int i = 0; i < number.length (); i++) {
            if (!Character.isDigit (number.charAt (i))) {
                return false;
            }
        }
        return true;
    }
}
