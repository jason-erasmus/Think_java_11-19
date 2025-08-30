package Chapter_12;
// package Chapter_11;

import java.util.Arrays;

public class Card {
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Card ranks and suits
    public String toString() {
        String[] ranks = { null, "Ace", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "Jack", "Queen", "King" };
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String s = ranks[this.rank] + " of " + suits[this.suit];
        return s;
    }

    // Compare card values
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        // Ace adjusted to > than King
        int thisAceAdjusted;
        if (this.rank == 1) {
            thisAceAdjusted = 14;
        } else {
            thisAceAdjusted = this.rank;
        }

        int thatAceAdjusted;
        if (that.rank == 1) {
            thatAceAdjusted = 14;
        } else {
            thatAceAdjusted = that.rank;
        }

        if (thisAceAdjusted < thatAceAdjusted) {
            return -1;
        }
        if (thisAceAdjusted > thatAceAdjusted) {
            return 1;
        }
        return 0;
    }

    // Generate Card Array
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];

        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    // Histogram of cards
    public static int suitHist(Card[] hand) {

        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.suit.length; j++) {

            }
        }
    }

    public static void main(String[] args) {
        Card card = new Card(11, 1);
        System.out.println(card);

        Card[] deck = makeDeck();
        System.out.println(Arrays.toString(deck));
    }
}
