package Chapter_13;

import java.util.Arrays;
import java.util.Random;
import Chapter_13.Card;

public class Deck {
    private Card[] cards;

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public Card[] getCards() {
        return this.cards;
    }

    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    // print Deck
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    // print toString method
    public String toString() {
        String result = "";
        for (Card card : this.cards) {
            if (card != null) {
                result += card.toString() + "\n";
            }
        }

        return result;
    }

    // Shuffle deck
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int j = randomInt(1, cards.length - 1);
            swapCards(i, j);
        }
    }

    private static final Random rand = new Random();

    public Random RandomUtil() {
        return rand;
    }

    // class method for shuffle
    private static int randomInt(int low, int high) {
        // int randomNum = (int) (Math.random() * (high - low) + low);
        // return a random number between low and high,
        // including both
        return rand.nextInt(high - low + 1) + low;
    }

    // instance method for shuffle
    private void swapCards(int i, int j) {
        // swap the ith and the jth cards in the array
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    // Sort the deck
    public void selectionSort() {
        for (int i = 0; i < cards.length; i++) {
            int lowestIndex = indexLowest(i, cards.length - 1);
            swapCards(i, lowestIndex);
        }
        // for each index i {
        // find the lowest card at or to the right of i
        // swap the ith card and the lowest card found
        // }
    }

    // find lowest index
    private int indexLowest(int low, int high) {
        // find the lowest card between low and high
        int lowestIndex = low;
        for (int i = low; i <= high; i++) {
            if (cards[i].compareTo(cards[lowestIndex]) < 0) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    // Merge sort

    // split deck in 2
    public Deck subDeck(int low, int high) {
        if (low < 0 || high >= this.cards.length || low > high) {
            throw new IllegalArgumentException("Invalid subDeck range: " + low + " to " + high);
        }

        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    // Merging the decks - helper method
    private static Deck merge(Deck d1, Deck d2) {
        // create a new deck, d3, big enough for all the cards
        int totalSize = d1.getCards().length + d2.getCards().length;
        Deck d3 = new Deck(totalSize);

        Card[] cards1 = d1.getCards();
        Card[] cards2 = d2.getCards();
        Card[] result = d3.getCards();
        // use the index i to keep track of where we are at in
        // the first deck, and the index j for the second deck

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < cards1.length && j < cards2.length) {
            if (cards1[i].compareTo(cards2[j]) <= 0) {
                result[k++] = cards1[i++];
            } else {
                result[k++] = cards2[j++];
            }
        }
        // Add remaining cards from d1
        while (i < cards1.length) {
            result[k++] = cards1[i++];
        }

        // Add remaining cards from d2
        while (j < cards2.length) {
            result[k++] = cards2[j++];
        }
        return d3;
    }

    // Simplified merge sort - see 13.6
    public Deck almostMergeSort() {

        // divide the deck into two subdecks
        // sort the subdecks using selectionSort
        // merge the subdecks, return the result
        // Deck test = new Deck();
        Deck sub1 = this.subDeck(0, 25);
        Deck sub2 = this.subDeck(26, 51);

        Card.aceHigh = false;
        sub1.selectionSort();
        sub2.selectionSort();

        Deck sorted = merge(sub1, sub2);

        return sorted;
    }

    // Merge decks using recursion - see 13.7
    public Deck mergeSort() {
        if (this.cards.length <= 1) {
            return this; // base case
        }

        Card.aceHigh = false;

        // divide the deck into two subdecks
        int mid = this.cards.length / 2;
        // Testing
        // System.out.println("Splitting deck from 0 to " + (cards.length - 1));
        // System.out.println("Left: 0 to " + (mid - 1));
        // System.out.println("Right: " + mid + " to " + (cards.length - 1));

        Deck left = this.subDeck(0, mid - 1);
        Deck right = this.subDeck(mid, this.cards.length - 1);

        Deck sortedLeft = left.mergeSort();
        Deck sortedRight = right.mergeSort();

        return merge(sortedLeft, sortedRight);
        // if the deck has 0 or 1 cards, return it
        // otherwise, divide the deck into two subdecks
        // sort the subdecks using mergeSort
        // merge the subdecks
        // return the result
    }

    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.shuffle();

        System.out.println("After shuffle:");
        System.out.println(deck);

        Deck sorted = deck.mergeSort();

        System.out.println("Sorted Deck: ");
        System.out.println(sorted);

    }
}
