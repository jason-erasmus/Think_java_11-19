package Chapter_13;

import java.util.Arrays;
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

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.print();
    }
}
