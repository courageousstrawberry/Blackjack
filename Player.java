import java.util.ArrayList;
import java.util.Scanner;

public class Player {
//Instance variables
ArrayList<Card> hand = new ArrayList<Card>();
Scanner scan = new Scanner(System.in);
//name
String name;
//Constructor
public Player(String nm) {
  System.out.println("What's your name?");
  name = scan.nextLine();
  name = nm;
}

//set name

//Hit or stay --
public boolean hitOrStay() {
  String input = "";
  boolean result = false;

  do{
    System.out.println("Do you want to hit or stay? (h/s)");
    input = scan.nextLine();
  }
  while (!(input.equals("h")) && !(input.equals("s")));

  if(input.equals("h")){
    result = true;
  }
  else if (input.equals("s")){
    result = false;
  }
  return result;
}

public void hit(Card c) {
//Add card to the player hand
hand.add(c);
}

public void showHand() {
  //Player should know what cards are in their hand
  System.out.println("Your cards are: ");
  for (int i = 0; i < hand.size(); i++){
    Card value = hand.get(i);
    System.out.println(value);
  }
}

public int calculateTotal() {
//Declare variable for total, set to zero
int total = 0;
//Assume ace is an 11 to start
//Loop through all cards in hand
//Add value of given card to total
for (Card value : hand) {
  total += value.getValue();

  if (total > 21 && value.getName().equals("ACE")){
    total = total - 10;
  }
}
//If total > 21 AND card was an Ace - subtract 10
//After exiting loop - return total
return total;
}

public boolean continueGame() {
//ask player about continuing game
  String input = "";
  boolean result = false;
  do {
    System.out.println("Do you want to continue playing? (y/n)");
    input = scan.nextLine();
  } while (input == "y" || input == "n");

  if (input.equals("y")) {
    result = true;
  }
  else if (input.equals("n")){
    result = false;
  }

  return result;
}


}
