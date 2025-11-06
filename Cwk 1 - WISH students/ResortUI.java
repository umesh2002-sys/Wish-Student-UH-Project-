import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{
    
    private Scanner reader = new Scanner(System.in);
    private WISH wayward = new Resort("Wayward Worlds");
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllWorlds();}
            else if (choice == 2){listOneWorld();}
            else if (choice == 3){findACard();}
            else if (choice == 4){tryTravel();}
            else if (choice == 5){travelNow();}
            else if (choice == 6){getCard();}
            else if (choice == 7){updateCoins();}
            else if (choice == 8){convertPoints();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all world details including cards");
       System.out.println("2. List all cards on one world");
       System.out.println("3. Find a card on a world");
       System.out.println("4. Say if card can travel by shuttle");
       System.out.println("5. Move a card by shuttle");
       System.out.println("6. Get card details");
       System.out.println("7. Top up bitcoins");
       System.out.println("8. Convert points");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // provide the code here
    private void listAllWorlds()
    {
        System.out.println(wayward.toString());
    }
    
   
    // This one has been done for you 
    private void listOneWorld()
    {
        System.out.println("Enter name of world");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllCardsOnOneWorld(ww));
    }
    
    // provide the code here
    private void findACard()
    {
        System.out.println("Enter card id");
        int cardId = reader.nextInt();
        reader.nextLine();  // Consume newline character
        String world = wayward.findCard(cardId);
        if (world != null) {
            System.out.println("Card is on world: " + world);
        } else {
            System.out.println("Card not found.");
        }
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // Provide the code here
    private void travelNow()
    {
        System.out.println("Enter card id");
        int cardId = reader.nextInt();
        reader.nextLine();  // Consume newline character
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.travel(cardId, shuttle));
    }
    
    
    // this one has been done for you
    private void getCard()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        
        System.out.println(wayward.getCardDetails(trav));
    }
    
    // provide the code here
    private void updateCoins()
    {
        System.out.println("Enter card id");
        int cardId = reader.nextInt();
        System.out.println("Enter number of bitcoins to add");
        int coins = reader.nextInt();
        reader.nextLine();  // Consume newline character
        wayward.topUpBitcoins(cardId, coins);
        System.out.println("Updated coins for card " + cardId);
    }
    
    // provide the code here
    private void convertPoints()
    {
        System.out.println("Enter card id");
        int cardId = reader.nextInt();
        reader.nextLine();  // Consume newline character
        wayward.convertPoints(cardId);
        System.out.println("Converted points to bitcoins for card " + cardId);
    }
   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
