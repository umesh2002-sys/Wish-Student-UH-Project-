
/**
 * Write a description of class TouristCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TouristCard extends Card {
    private String citizenship; // Planet they come from

    // Constructor to initialize a tourist card with luxury rating, bitcoins, and citizenship
    public TouristCard(int cardId, String name, int luxuryRating, int bitcoins, String citizenship) {
        super(cardId, name, luxuryRating, bitcoins);  // Call the parent constructor
        this.citizenship = citizenship;
    }

    // Override toString() to include citizenship and other details specific to TouristCard
    @Override
    public String toString() {
        return super.toString() + ", Citizenship: " + citizenship;
    }
}
