package Chapter_13;

import java.util.Arrays;

public class Card {
    // Static flag for adjusting Ace value
    public static boolean aceHigh = true;

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
        if (this.suit != that.suit) {
            return this.suit - that.suit;
        }
        // Ace adjusted to > than King
        int thisRank = (this.rank == 1 && aceHigh) ? 14 : this.rank;

        int thatRank = (that.rank == 1 && aceHigh) ? 14 : that.rank;

        return thisRank - thatRank;
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
        int[] flushRank = { 1, 10, 11, 12, 13 };

        for (int suit = 0; suit < SUITS.length; suit++) {
            int count = 0;
            for (int rank : flushRank) {
                boolean found = false;
                for (Card card : hand) {
                    if (card.rank == rank && card.suit == suit) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    count++;
            }
            if (count == 5)
                return true;
        }
        return false;

    }

    // for (String x : isFlush) {
    // System.out.println(x);
    // }

    public static void main(String[] args) {
        Card card = new Card(11, 1);
        System.out.println(card);

        Card[] deck = makeDeck();
        System.out.println(Arrays.toString(deck));

        Card[] hand = {
                new Card(1, 2), // Ace of Hearts
                new Card(13, 2), // King of Hearts
                new Card(10, 2), // 10 of Hearts
                new Card(11, 2), // Jack of Hearts
                new Card(12, 2), // Queen of Hearts
                new Card(3, 0) // 3 of Clubs
        };
        int[] histogram = suitHist(hand);
        System.out.println("Suit histogram: " + Arrays.toString(histogram));

        System.out.println(hasFlush(hand));
        System.out.println(hasRoyalFlush(hand));
    }
}
