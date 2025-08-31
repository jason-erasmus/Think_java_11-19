// package Chapter_12;
// package Chapter_11;

import java.util.Arrays;

public class Card {

    private int rank;
    private int suit;
    public static final String[] RANKS = {
            null, "Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King" };

    public static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades" };

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Card ranks and suits
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
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
    public static int[] suitHist(Card[] hand) {

        int[] counts = new int[SUITS.length];

        for (int i = 0; i < hand.length; i++) {
            int suitIndex = hand[i].suit;
            counts[suitIndex]++;
        }
        return counts;
    }

    // Check for Flush
    public static boolean hasFlush(Card[] hand) {
        int[] counts = suitHist(hand);

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 5) {
                return true;
            }
        }
        return false;
    }

    // Check for Royal Flush
    public static boolean hasRoyalFlush(Card[] hand) {
        int[] counts = suitHist(hand);

    }

    public static void main(String[] args) {
        Card card = new Card(11, 1);
        System.out.println(card);

        Card[] deck = makeDeck();
        // System.out.println(Arrays.toString(deck));

        Card[] hand = {
                new Card(1, 2), // Ace of Hearts
                new Card(13, 2), // King of Hearts
                new Card(10, 2), // 10 of Hearts
                new Card(5, 2), // 5 of Hearts
                new Card(7, 2), // 7 of Hearts
                new Card(3, 0) // 3 of Clubs
        };
        int[] histogram = suitHist(hand);
        System.out.println("Suit histogram: " + Arrays.toString(histogram));

        System.out.println(hasFlush(hand));
    }
}
