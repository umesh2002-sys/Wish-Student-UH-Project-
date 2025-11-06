import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author 
 * @version 
 */
public class MyTester 
{   
    private void doTest()
    {
        // write your tests here
        // Create a Resort object via the WISH interface (polymorphic creation)
        WISH wayward = new Resort("Wayward Worlds");

        // Test 1: List all world details including cards
        System.out.println("Test 1: List all world details including cards");
        System.out.println(wayward.toString());  // Calling the toString method to list all worlds and cards
        System.out.println();

        // Test 2: List all cards on a specific world
        System.out.println("Test 2: List all cards on a specific world");
        System.out.println("Listing cards on 'Home' world:");
        System.out.println(wayward.getAllCardsOnOneWorld("Home"));  // Test getAllCardsOnOneWorld method
        System.out.println();

        // Test 3: Find a card and the world it is located on
        System.out.println("Test 3: Find a card and the world it is located on");
        System.out.println("Finding card with ID 1000:");
        System.out.println(wayward.findCard(1000));  // Test findCard method for card 1000 (Lynn)
        System.out.println("Finding card with ID 10005 (non-existent):");
        System.out.println(wayward.findCard(10005));  // Test findCard for a card that doesn't exist and return Null
        System.out.println();

        // Test 4: Check if a card can travel by shuttle
        System.out.println("Test 4: Check if a card can travel by shuttle");
        System.out.println("Can card with ID 1000 travel by shuttle 'ABC1'?");
        System.out.println(wayward.canTravel(1000, "ABC1"));  // Test canTravel for valid card and shuttle
        System.out.println("Can card with ID 1004 travel by shuttle 'ABC1'?");
        System.out.println(wayward.canTravel(1004, "ABC1"));  // Test canTravel for card with insufficient bitcoins
        System.out.println();

        // Test 5: Try to move a card using a shuttle
        System.out.println("Test 5: Try to move a card using a shuttle");
        System.out.println("Moving card with ID 1000 using shuttle 'ABC1':");
        System.out.println(wayward.travel(1000, "ABC1"));  // Test travel for valid card and shuttle
        System.out.println("Moving card with ID 10001 using shuttle 'ABC1' (non-existent card):");
        System.out.println(wayward.travel(10001, "ABC1"));  // Test travel for non-existent card
        System.out.println("Moving card with ID 1000 using shuttle 'XYZ9' (invalid shuttle):");
        System.out.println(wayward.travel(1000, "XYZ9"));  // Test travel for invalid shuttle code
        System.out.println();

        // Test 6: Get card details
        System.out.println("Test 6: Get card details");
        System.out.println("Details of card with ID 1000:");
        System.out.println(wayward.getCardDetails(1000));  // Test getCardDetails for a valid card
        System.out.println("Details of card with ID 9999 (non-existent):");
        System.out.println(wayward.getCardDetails(9999));  // Test getCardDetails for a non-existent card
        System.out.println();

        // Test 7: Top up bitcoins for a card
        System.out.println("Test 7: Top up bitcoins for a card");
        System.out.println("Topping up card with ID 1000 by 5 bitcoins:");
        wayward.topUpBitcoins(1000, 5);  // Test topUpBitcoins for a valid card
        System.out.println(wayward.getCardDetails(1000));  // Verify the new bitcoin balance
        System.out.println("Topping up card with ID 9999 by 5 bitcoins (non-existent card):");
        wayward.topUpBitcoins(9999, 5);  // Test topUpBitcoins for a non-existent card
        System.out.println();

        // Test 8: Convert points to bitcoins for a card
        System.out.println("Test 8: Convert points to bitcoins for a card");
        System.out.println("Converting points for card with ID 1000:");
        wayward.convertPoints(1000);  // Test convertPoints for a card
        
        System.out.println(wayward.travel(1000, "CDE3"));
        System.out.println(wayward.travel(1000, "JKL8"));
        System.out.println("Getting Card Details Points should be 3"); 
        System.out.println(wayward.getCardDetails(1000));  // Verify the updated bitcoin balance
        wayward.convertPoints(1000);  // Test convertPoints for a card
        System.out.println("Viewing Card Details after converting points into bitcoin");
        System.out.println(wayward.getCardDetails(1000));
        System.out.println("Converting points for card with ID 9999 (non-existent card):");
        wayward.convertPoints(9999);  // Test convertPoints for a non-existent card
        System.out.println();
        
        
        // Test 9: traving multiple destination No Bitcoin sufficent add more bitcoin to travel
        System.out.println("Test 8: Traving multiple destination No Bitcoin sufficent add more bitcoin to travel");
        System.out.println("Converting points for card with ID 1000:");        
        System.out.println(wayward.travel(1000, "EFG5"));
        System.out.println(wayward.travel(1000, "GHJ6"));
        System.out.println("No Bitcoin remaining should dsiplay"); 
        System.out.println(wayward.getCardDetails(1000));  // Verify the updated bitcoin balance
        wayward.convertPoints(1000);  // Test convertPoints for a card
        System.out.println();
        
        
        //Test 10: Checking card 1000 travel to solo
        System.out.println("Test 10: Checking card 1000 travel to solo");
        System.out.println(wayward.findCard(1000));
        wayward.topUpBitcoins(1000, 5);
        System.out.println();
        
        //Test 11: Try if multiple card can stay in Solo world
        System.out.println("Test 11: Try if multiple card can stay in Solo world"); 
        System.out.println("Card 1000 at Solo World");  
        System.out.println(wayward.travel(1000, "GHJ6"));
        System.out.println("Card 1001 to Solo World");
        System.out.println("Insuffecient capacity shuld display");
        System.out.println(wayward.travel(1001, "ABC1"));
        System.out.println("Destination World is full massage should Display");
        System.out.println(wayward.travel(1001, "GHJ6"));
    }
     
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
