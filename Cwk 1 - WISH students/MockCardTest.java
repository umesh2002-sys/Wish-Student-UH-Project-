
/**
 * Write a description of class MockCardTest here.
 *
 * @author (Umesh Shahu Shrestha)
 * @version (a version number or a date)
 */
public class MockCardTest
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
    
        Card cardX = new Card(765, "Fred", 6, 20);
        cardX.deductBitcoins(10);
        System.out.println(cardX);
        System.out.println("\nHas Enough Bitcoins for a Journey (4): " + cardX.hasEnoughBitcoins(4));

    }
}
