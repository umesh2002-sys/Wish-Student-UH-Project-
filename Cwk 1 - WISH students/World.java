import java.util.*;
/**
 * An world is part of a WISH resort.Each world has a reference number, name, 
 * a luxury rating and a capacity which represents the maximum number of 
 * cards that can be on the world at any one time. Each world must 
 * maintain a list of all cards currently on that world. This list 
 * is updated whenever cards arrive or leave a world,so that it is always 
 * possible to say which cards are on the world and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class World 
{
    // Fields
    private int worldNumber;
    private String name;
    private int luxuryRating; // 0 to 10
    private int capacity;
    private ArrayList<Card> cards; // List to store cards present in the world

    // Constructor
    public World(int worldNumber, String name, int luxuryRating, int capacity) {
        this.worldNumber = worldNumber;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.capacity = capacity;
        this.cards = new ArrayList<>(); // Initialize the ArrayList
    }

    // Accessor methods
    public int getWorldNumber() {
        return worldNumber;
    }

    public String getName() {
        return name;
    }

    public int getLuxuryRating() {
        return luxuryRating;
    }

    // Method to check if a card is on the world
    public boolean isCardOnWorld(int cardId) {
        for (Card card : cards) {
            if (card.getCardId() == cardId) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the world has capacity and cards.size() refer to size of world
    //  . size() method of the ArrayList class returns the number of elements in the list.
    public boolean hasCapacity() {
        return cards.size() < capacity;
    }

    // Method to add a card (arrive)
    public void arrive(Card card) {
        if (hasCapacity()) {
            cards.add(card);
        }
        // else {
        // System.out.println("World is full. Cannot add card.");
        // }
    }

    // Method to remove a card (leave)

    public void leave(Card card) {
        // If the card exists, remove it from the cards list
        if (card != null) {
            cards.remove(card);
        }
    }

    // Method to get details of a card by ID
    public Card getCardById(int cardId) {
        for (Card card : cards) {
            if (card.getCardId() == cardId) {
                return card;
            }
        }
        return null; // Return null if card not found
    }

    @Override
    public String toString() {
        String result = "World Details:\n";
        result += "World Number: " + worldNumber +
        ", Name: " + name +
        ", Luxury Rating: " + luxuryRating +
        ", Capacity: " + capacity +
        ", Current Occupants: " + cards.size() + "\n";

        result += "Cards on this world:\n";
        for (Card card : cards) {
            result += card + "\n";
        }
        return result;
    }

}
