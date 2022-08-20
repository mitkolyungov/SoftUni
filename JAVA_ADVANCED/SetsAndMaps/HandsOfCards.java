import java.util.*;

public class HandsOfCards {

    private enum CardType {
        S (4),
        H (3),
        D (2),
        C (1);

        private int value;

        CardType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private enum CardPower {
        J (11),
        Q (12),
        K (13),
        A (14);


        private int value;

        CardPower(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Set<String>> map = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("JOKER")) {
            String[] splitCommand = command.split (": ");
            String[] cards = splitCommand[1].split (", ");

            String name = splitCommand[0];

            map.putIfAbsent (name, new HashSet<> ());
            map.get (name).addAll (List.of (cards));

            command = scanner.nextLine ();
        }

        for (var entry : map.entrySet ()) {
            System.out.print (entry.getKey () + ": ");


            int total = 0;

            for (String s : entry.getValue ()) {
                String power = s.substring (0, s.length () - 1);
                char type = s.charAt (s.length () - 1);

                CardType cardType = CardType.valueOf (String.valueOf (type));

                if (Character.isDigit (power.charAt (0)) || s.length () == 3) {
                    total += Integer.parseInt (power) * cardType.getValue ();
                } else {
                    CardPower cardPower = CardPower.valueOf (power);
                    total += cardPower.getValue () * cardType.getValue ();
                }
            }

            System.out.println (total);
        }
    }
}
