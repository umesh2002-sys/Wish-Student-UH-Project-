import java.util.*;

/**This class implements the WISH interface
 *
 * @author A.A.Marczyk 
 * @version 01/11/24
 **/
public class Resort implements WISH
{

    // more fields to be added
    private String location;
    private ArrayList<World> worlds;
    private ArrayList<Card> cards;
    private HashMap<String, Shuttle> shuttles;

    /** constructor
     * @param loc - the location of the resort
     */
    public Resort(String loc) 
    {
        location = loc;
        worlds = new ArrayList<>();
        cards = new ArrayList<>();
        shuttles = new HashMap<>();
        loadWorlds();
        loadCards();
        setUpShuttles();
    }

    /**
     * Returns all of the details of all worlds including the cards
     * currently on each world, on "No cards"
     * @return all of the details of all worlds including location 
     * and all cards currently on each world, or "No cards" 
     */
    public String toString()
    {
        StringBuilder details = new StringBuilder("Resort Location: " + location + "\n");
        for (World world : worlds) {
            details.append(world).append("\n");
        }
        return details.toString();
    }

    /**Returns the name of the world which contains the specified card or null
     * @param tr - the specified card
     * @return the name of the World which contains the card, or null
     **/
    public String findCard(int tr)
    {
        for (World world : worlds) {
            if (world.isCardOnWorld(tr)) {
                return world.getName();
            }
        }
        return null;
    }

    /** Given the name of a world, returns the world id number
     * or -1 if world does not exist
     * @param name of world
     * @return id number of world
     */
    public int getWorldNumber(String ww)
    {
        for (World world : worlds) {
            if (world.getName().equals(ww)) {
                return world.getWorldNumber();
            }
        }
        return -1;
    }

    /**Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     **/
    public String getAllCardsOnOneWorld(String world)
    {
        World targetWorld = getWorld(world);
        if (targetWorld == null) {
            return "World not found.";
        }
        return targetWorld.toString();
    } 

    /**Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param trId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return true if the card is allowed on the shuttle journey, false otherwise 
     **/
    public boolean canTravel(int trId, String shtlCode)
    {   //other checks optional
        Card card = getCard(trId);
        Shuttle shuttle = getShuttle(shtlCode);

        if(card == null || shuttle == null){
            return false;
        }
        return shuttle.canCardEnter(card);
    }     

    /**Returns the result of a card requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the card information is removed from the source
     * world, added to the destination world and a suitable message returned.
     * 
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * 
     * @param pCardId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return a String giving the result of the request 
     **/
    public String travel(int pCardId, String shtlCode )
    {   //other checks optional
        Card card = getCard(pCardId);
        Shuttle shuttle = getShuttle(shtlCode);

        if(card == null){
            return "Card not found.";
        }
        if(shuttle == null){
            return "Shuttle not found.";
        }
        return shuttle.processCardMovement(card);
    } 

    /** 
     * returns details of a card, or "No such card" 
     */
    public String getCardDetails(int id)
    {
        Card card = getCard(id);
        if (card != null) {
            return card.toString();
        } else {
            return "No such card";
        }
    }

    /** Allows a card to top up their bitcoins.This method is not concerned with 
     *  the cost of a bitcoin as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their bitcoins
     *  @param coins the number of bitcoins to be added to card 
     */
    public void topUpBitcoins(int id, int coins)
    {
        Card card = getCard(id);
        if(card != null){
            card.addBitcoins(coins);
        }
    }

    /** Allows the points on a card to be converted to bitCoins (3 points = 1 bitcoin)
     *  @param id the id of the card converting their points
     */
    public void convertPoints(int id)
    {
        Card card = getCard(id);
        if(card != null){
            card.convertPointsToBitcoins();
        }
    }
    //***************private methods**************
    private void loadWorlds()
    {
        worlds.add(new World(0, "Home", 0, 1000));
        worlds.add(new World(1, "Sprite", 1, 100));
        worlds.add(new World(2, "Tropicana", 3, 10));
        worlds.add(new World(3, "Fantasia", 5, 2));
        worlds.add(new World(4, "Solo", 1, 1));
        
        // a World 5 Pepsi with a rating of 1, capacity 3
        worlds.add(new World(5, "Pepsi", 1, 3));
    }

    private void setUpShuttles()
    {
        shuttles.put("ABC1", new Shuttle("ABC1", getWorld("Home"), getWorld("Sprite")));
        shuttles.put("BCD2", new Shuttle("BCD2", getWorld("Sprite"), getWorld("Home")));
        shuttles.put("CDE3", new Shuttle("CDE3", getWorld("Sprite"), getWorld("Tropicana")));
        shuttles.put("DEF4", new Shuttle("DEF4", getWorld("Tropicana"), getWorld("Sprite")));
        shuttles.put("EFG5", new Shuttle("EFG5", getWorld("Fantasia"), getWorld("Sprite")));
        shuttles.put("GHJ6", new Shuttle("GHJ6", getWorld("Sprite"), getWorld("Solo")));
        shuttles.put("HJK7", new Shuttle("HJK7", getWorld("Solo"), getWorld("Sprite")));
        shuttles.put("JKL8", new Shuttle("JKL8", getWorld("Tropicana"), getWorld("Fantasia")));
        
        //  Shuttle LLL from Solo to Pepsi, and Shuttle MMM from Pepsi to Sprite
        //shuttles.put("LLL", new Shuttle("LLL", getWorld("Solo"), getWorld("Shuttle")));
        //shuttles.put("MMM", new Shuttle("MMM", getWorld("Pepsi"), getWorld("Sprite")));
    }

    private void loadCards()
    {
        cards.add(new Card(1000, "Lynn", 5, 10));
        cards.add(new Card(1001, "May", 3, 20));
        cards.add(new Card(1002, "Nils", 10, 20));
        cards.add(new Card(1003, "Olek", 2, 12));
        cards.add(new Card(1004, "Pan", 3, 3));
        cards.add(new Card(1005, "Quin", 1, 5));
        cards.add(new Card(1006, "Raj", 10, 6));
        cards.add(new Card(1007, "Sol", 7, 20));
        cards.add(new Card(1008, "Tel", 6, 24));
        cards.add(new Card(1009, "Zan", 9, 50));
        
        // 98 with a rating of 4 and credits 10 and name "Zizi"
        cards.add(new Card(98, "Zizi", 4, 10));
        
        //Rough program
        //cards.add(new Card(1010, "Una", 5, 10,"Earth"));        
        
        // every card in Home world initially
        World home = worlds.get(0);
        for (Card card : cards) {
            home.arrive(card);
        }
    }

    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified id
     **/
    private Card getCard(int id)
    {
        for(Card card : cards){
            if(card.getCardId() == id){
                return card;
            }
        }
        return null;
    }

    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
    private World getWorld(String worldName)
    {
        for(World world : worlds){
            if(world.getName().equals(worldName)){
                return world;
            }
        }
        return null;
    }

    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
    private Shuttle getShuttle(String shut)
    {
        return shuttles.get(shut);
    }
}