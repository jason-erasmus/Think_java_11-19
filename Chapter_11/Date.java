// package Chapter_11;
public class Date {
    private int year;
    private int month;
    private int day;

    // Default constructor
    public Date() {
        this.year = 1999;
        this.month = 1;
        this.day = 1;
    }

    // Value constructor
    public Date(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Display Date objects
    public static void printDate(Date d) {
        System.out.printf("The date is %02d/%02d/%04d\n",
                d.day, d.month, d.year);
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(10, 12, 1991);

        printDate(date1);
        printDate(date2);
    }
}
