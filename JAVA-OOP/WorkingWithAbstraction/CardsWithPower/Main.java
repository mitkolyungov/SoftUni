import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        CardRank cardRank = CardRank.valueOf (scanner.nextLine ());
        Suit suit = Suit.valueOf (scanner.nextLine ());

        Card card = new Card (cardRank, suit);

        System.out.printf ("Card name: %s of %s; Card power: %d"
                , card.getCardRank ().name (), card.getSuit ().name (), card.getPowerOfCard ());
    }
}
