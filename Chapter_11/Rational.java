package Chapter_11;

public class Rational {
    private int num;
    private int denom;

    // Default constructor
    public Rational() {
        this.num = 0;
        this.denom = 1;
    }

    // Value constructor
    public Rational(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    // Print objects
    public static void printRational(Rational r) {
        System.out.printf("%d / %d\n", r.num, r.denom);
    }

    // toString override
    public String toString() {
        return String.format("%d / %d\n", this.num, this.denom);
    }

    // Reverse sign of Rational
    public void negate() {
        this.num = -this.num;
    }

    // Invert Rational
    public void invert() {
        int temp = this.num;
        this.num = this.denom;
        this.denom = temp;
    }

    // Convert Rational to Double
    public double toDouble() {
        return (double) num / denom;
    }

    // Greatest common divisor
    public static int reduce(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Add
    public Rational add(Rational t) {
        // x = n1 * d2 + n2 * d1
        int newNum = this.num * t.denom + t.num * this.denom;
        // y = d1 * d2;
        int newDenom = this.denom * t.denom;

        int gcd = reduce(newNum, newDenom);
        newNum /= gcd;
        newDenom /= gcd;

        return new Rational(newNum, newDenom);
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(4, 8);
        Rational r3 = new Rational(3, 6);
        Rational r4 = new Rational(2, 3);
        Rational r5 = new Rational(4, 8);

        printRational(r1);
        System.out.println(r2);

        r2.negate();
        System.out.println("Negated: " + r2);

        r3.invert();
        System.out.println("Inverted: " + r3);

        double doubleNum = r1.toDouble();
        System.out.println("Double: " + doubleNum);

        int gcd = reduce(r3.num, r3.denom);
        System.out.println("GCD: " + gcd);

        Rational sum = r4.add(r5);
        System.out.println("Sum: " + sum);
    }

}
