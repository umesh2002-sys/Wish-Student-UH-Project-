
/**
 * A shuttle provides a one-way connection between two worlds. It
 * has a Shuttle code and information about both the source and
 * the destination world
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle
{
    // Fields
    private String journeyCode;
    private World fromWorld;
    private World toWorld;

    // Constructor
    public Shuttle(String journeyCode, World fromWorld, World toWorld) {
        this.journeyCode = journeyCode;
        this.fromWorld = fromWorld;
        this.toWorld = toWorld;
    }

    // Accessors
    public String getJourneyCode() {
        return journeyCode;
    }

    public World getFromWorld() {
        return fromWorld;
    }

    public World getToWorld() {
        return toWorld;
    }
    
    // Check if a card can enter the shuttle
    public boolean canCardEnter(Card card) {
        // Conditions:
        // 1. Luxury rating of the card must meet or exceed the destination world's rating
        // 2. Destination world must have capacity
        // 3. Card must have enough bitcoins for the journey
        // 4. Card must be in the source world
        return card.getLuxuryRating() >= toWorld.getLuxuryRating()
                && toWorld.hasCapacity()
                && card.hasEnoughBitcoins(4) // Assuming the journey cost is 4 bitcoins
                && fromWorld.isCardOnWorld(card.getCardId());
    }
    
    // Process moving a card
    public String processCardMovement(Card card) {
        if (canCardEnter(card)) {
            // Update worlds
            fromWorld.leave(card);
            toWorld.arrive(card);

            // Update card information
            card.updateAfterShuttleJourney();

            return "Card " + card.getCardId() + " Successfully moved from " +
                    fromWorld.getName() + " to " + toWorld.getName() + ".";
        } else {
            // Determine why the card cannot enter
            if (card.getLuxuryRating() < toWorld.getLuxuryRating()) {
                return "Card " + card.getCardId() + " Cannot enter: insufficient luxury rating.";
            } else if (!toWorld.hasCapacity()) {
                return "Card " + card.getCardId() + " Cannot enter: destination world is full.";
            } else if (!card.hasEnoughBitcoins(4)) {
                return "Card " + card.getCardId() + " Cannot enter: insufficient bitcoins.";
            } else if (!fromWorld.isCardOnWorld(card.getCardId())) {
                return "Card " + card.getCardId() + " Cannot enter: not in the source world.";
            }
            return "Card " + card.getCardId() + " Cannot enter: unknown error.";
        }
    }
    
    
    // toString method
    @Override
    public String toString() {
        return "Shuttle Journey Code: " + journeyCode +
               "\nFrom World: " + fromWorld.getName() + " (World #" + fromWorld.getWorldNumber() + ")" +
               "\nTo World: " + toWorld.getName() + " (World #" + toWorld.getWorldNumber() + ")";
    }
}
