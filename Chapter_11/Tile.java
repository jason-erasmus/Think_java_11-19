package Chapter_11;

public class Tile {
    private char letter;
    private int value;

    // Default constructor
    public Tile() {
        this.letter = ' ';
        this.value = 0;
    }

    // Value constructor
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    /**
     * The function `printTile` prints the letter and point value of a given Tile
     * object.
     * 
     * @param t Tile object representing a letter tile in a word game, containing
     *          the following attributes:
     */
    public static void printTile(Tile t) {
        System.out.printf("Your tile is %c which is worth %d points!\n", t.letter, t.value);
    }

    // toString method
    public String toString() {
        return String.format("Tile: %c\nPoints: %02d\n", this.letter, this.value);
    }

    // Equals method
    public boolean equals(Tile that) {
        return this.letter == that.letter
                && this.value == that.value;
    }

    // Getters
    public char getLetter() {
        return this.letter;
    }

    public int getValue() {
        return this.value;
    }

    // Setters
    public void setLetter() {
        this.letter = letter;
    }

    public void setValue() {
        this.value = value;
    }

    public static void main(String[] args) {
        Tile test = new Tile('Z', 10);
        printTile(test);

        System.out.println(test);
        Tile test1 = new Tile('Z', 10);
        System.out.println("Are they equal? " + test.equals(test1));
    }
}
