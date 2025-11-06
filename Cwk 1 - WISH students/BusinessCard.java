
/**
 * Write a description of class BusinessCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusinessCard extends Card 
{
    private int freeDrinks; // Number of free drinks remaining

    // Constructor to initialize a business card with luxury rating, 30 bitcoins, and 10 free drinks
    public BusinessCard(int cardId, String name, int luxuryRating) {
        super(cardId, name, luxuryRating, 30);  // 30 bitcoins by default
        this.freeDrinks = 10;  // 10 free drinks by default
    }

    // Override toString() to include free drinks remaining and other details specific to BusinessCard
    @Override
    public String toString() {
        return super.toString() + ", Free Drinks: " + freeDrinks;
    }

    // Deduct 1 free drink whenever a shuttle journey is made
    @Override
    public void updateAfterShuttleJourney() {
        deductBitcoins(3); // Deduct 3 bitcoins
        if (freeDrinks > 0) {
            freeDrinks--; // Remove 1 free drink if available
        }
        // No need to add points here as it's already handled in the parent class
    }
}
