import java.util.Scanner;

public class MainRhombus {
    static class Rhombus {
        int size;
        public Rhombus(int size) {
            this.size = size;
        }
        public String getFigure() {

            return getTop (size) + getMiddle (size) + getBottom (size);
        }
        private String getBottom(int length) {
            StringBuilder sb = new StringBuilder ();

            for (int i = 1; i < length; i++) {
                sb.append (printSpacesAndStars (i, " ")).append (printSpacesAndStars (length - i, "* ")).append (System.lineSeparator ());
            }

            return sb.toString ();
        }

        private String getMiddle(int length) {
            return printSpacesAndStars (length, "* ") + System.lineSeparator ();
        }

        private String getTop(int length) {
            StringBuilder sb = new StringBuilder ();

            for (int i = 1; i < length; i++) {
                sb.append (printSpacesAndStars (length - i, " ")).append (printSpacesAndStars (i, "* ")).append (System.lineSeparator ());
            }

            return sb.toString ();
        }

        private String printSpacesAndStars(int length, String symbol) {
            return symbol.repeat (length);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int size = Integer.parseInt (scanner.nextLine ());

        Rhombus rhombus = new Rhombus (size);

        System.out.println (rhombus.getFigure ());
    }
}
