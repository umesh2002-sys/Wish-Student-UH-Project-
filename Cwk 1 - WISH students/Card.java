
/**
 * A Card has an id number, name, a luxury rating , number of bitcoins, points.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card 
{
    private int cardId;
    private String name;
    private int luxuryRating;
    private int bitcoins;
    private int points;
    
    // Constructor of class Card
    public Card(int cardId, String name, int luxuryRating, int bitcoins) {
        this.cardId = cardId;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.bitcoins = bitcoins;
        this.points = 0; // Default initial points
    }
    
    // Accessor methods
    public int getCardId() {
        return cardId;
    }

    public int getLuxuryRating() {
        return luxuryRating;
    }

    public int getBitcoins() {
        return bitcoins;
    }
    
    // Method to add bitcoins
    public void addBitcoins(int amount) {
        if (amount > 0) {
            bitcoins += amount;
        }
    }
    
    // Method to deduct bitcoins
    public void deductBitcoins(int amount) {
        if (amount > 0 && amount <= bitcoins) {
            bitcoins -= amount;
        }
    }
    
    // Method to check if the card has enough bitcoins for a journey
    public boolean hasEnoughBitcoins(int requiredBitcoins) {
        return bitcoins >= requiredBitcoins;
    }
    
    // Method to convert points to bitcoins
    public void convertPointsToBitcoins() {
        int bitcoinsToAdd = points / 3; // 3 points = 1 bitcoin
        bitcoins += bitcoinsToAdd; // bitcoins = bitcoins + bitcoinsToAdd;
        points %= 3; // Remainder points
    }
    
    // Method to update card after taking a shuttle
    public void updateAfterShuttleJourney() {
        deductBitcoins(4); // Deduct 4 bitcoins for shuttle journey
        points += 1;       // Add 1 point for the journey
    }
    
    // toString method
    @Override
    public String toString() {
        return "Card ID: " + cardId +
               "\nName: " + name +
               "\nLuxury Rating: " + luxuryRating +
               "\nBitcoins: " + bitcoins +
               "\nPoints: " + points;
    }
}

