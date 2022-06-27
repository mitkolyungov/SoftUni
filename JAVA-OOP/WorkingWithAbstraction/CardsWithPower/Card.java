public class Card {
    CardRank cardRank;
    Suit suit;

    public Card(CardRank cardRank, Suit suit) {
        this.cardRank = cardRank;
        this.suit = suit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getPowerOfCard() {
        return cardRank.getPower () + suit.getPower ();
    }
}
