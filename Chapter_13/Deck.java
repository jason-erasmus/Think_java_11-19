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
        // for each index i {
        // find the lowest card at or to the right of i
        // swap the ith card and the lowest card found
        // }
    }

    // find lowest index
    private int indexLowest(int low, int high) {
        // find the lowest card between low and high
        return 0;
    }

    // Merge sort

    // split deck in 2
    public Deck subDeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    // Merging the decks - helper method
    // private static Deck merge(Deck d1, Deck d2) {
    // // create a new deck, d3, big enough for all the cards

    // // use the index i to keep track of where we are at in
    // // the first deck, and the index j for the second deck
    // int i = 0;
    // int j = 0;

    // // the index k traverses the result deck
    // // for (int k = 0; k < d3.length; k++) {
    // // if d1 is empty, use top card from d2
    // // if d2 is empty, use top card from d1
    // // otherwise, compare the top two cards

    // // add lowest card to the new deck at k
    // // increment i or j (depending on card)
    // // }

    // // return the new deck
    // return Deck test
    // }

    // Simplified merge sort - see 13.6
    // public Deck almostMergeSort() {
    // // divide the deck into two subdecks
    // // sort the subdecks using selectionSort
    // // merge the subdecks, return the result
    // return Deck test;
    // }

    // Merge decks using recursion - see 13.7
    // public Deck mergeSort() {
    // // if the deck has 0 or 1 cards, return it
    // // otherwise, divide the deck into two subdecks
    // // sort the subdecks using mergeSort
    // // merge the subdecks
    // // return the result
    // }

    public static void main(String[] args) {

        Deck deck = new Deck();
        // deck.print();
        // System.out.println(deck);

        // test shuffle
        System.out.println("Before shuffle:");
        System.out.println(deck);

        deck.shuffle();

        System.out.println("After shuffle:");
        System.out.println(deck);
    }
}
