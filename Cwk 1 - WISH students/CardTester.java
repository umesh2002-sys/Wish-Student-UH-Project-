
/**
 * Write a description of class CardTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardTester
{
    public static void main(String[] args) {
        //Intial Card Test
        Card card = new Card(1000, "Lynn", 5, 10);

        // System.out.println("Initial Card Details:");
        // System.out.println(card);

        // card.addBitcoins(5);
        // System.out.println("\nAfter Adding 5 Bitcoins:");
        // System.out.println(card);

        // card.deductBitcoins(4);
        // System.out.println("\nAfter Deducting 4 Bitcoins:");
        // System.out.println(card);

        // System.out.println("\nHas Enough Bitcoins for a Journey (4): " + card.hasEnoughBitcoins(4));

        // card.updateAfterShuttleJourney();
        // System.out.println("\nAfter Shuttle Journey:");
        // System.out.println(card);

        // card.convertPointsToBitcoins();
        // System.out.println("\nAfter Converting Points to Bitcoins:");
        // System.out.println(card);
        
        
        // After Task 7 Table Included
        // Step 1: Create objects based on the table data
        // Creating instances of the different types of cards
        TouristCard touristCard = new TouristCard(1010, "Una", 5, 10, "Earth");
        BusinessCard businessCard = new BusinessCard(1011, "Val", 3);
        StaffCard staffCard = new StaffCard(1012, "Wei", 1, 12345, "Pilot");

        // // TouristCard Testing
        // TouristCard touristCard = new TouristCard(1010, "Una", 5, 10, "Earth");
        // System.out.println(touristCard);
        // System.out.println();
        
        // //Adding Bitcoin on TouristCard Testing
        // touristCard.addBitcoins(5);
        // System.out.println("\nAfter Adding 5 Bitcoins:");
        // System.out.println(touristCard);
        
        // touristCard.deductBitcoins(5);
        // System.out.println("\nAfter Deducting 5 Bitcoins:");
        // System.out.println(touristCard);
        
        // touristCard.updateAfterShuttleJourney();
        // System.out.println("\nAfter Shuttle Journey:");
        // System.out.println(touristCard);
        
        // //Business Card Testing
        // BusinessCard businessCard = new BusinessCard(1011, "Val", 3);
        // System.out.println(businessCard);
        // System.out.println();
        
        // //Adding Bitcoin on TouristCard Testing
        // businessCard.addBitcoins(5);
        // System.out.println("\nAfter Adding 5 Bitcoins:");
        // System.out.println(businessCard);
        
        // businessCard.deductBitcoins(5);
        // System.out.println("\nAfter Deducting 5 Bitcoins:");
        // System.out.println(businessCard);
        
        // businessCard.updateAfterShuttleJourney();
        // System.out.println("\nAfter Shuttle Journey:");
        // System.out.println(businessCard);
        
        
        // //Staff Card Testing
        // StaffCard staffCard = new StaffCard(1012, "Wei", 1, 12345, "Pilot");
        // System.out.println(staffCard);
        // System.out.println();
        
        // //Adding Bitcoin on TouristCard Testing
        // staffCard.addBitcoins(5);
        // System.out.println("\nAfter Adding 5 Bitcoins:");
        // System.out.println(staffCard);
        
        // staffCard.deductBitcoins(5);
        // System.out.println("\nAfter Deducting 5 Bitcoins:");
        // System.out.println(staffCard);
        
        // staffCard.updateAfterShuttleJourney();
        // System.out.println("\nAfter Shuttle Journey:");
        // System.out.println(staffCard);
    }
}
