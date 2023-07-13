import java.util.ArrayList;

public class Dealer {
//Instance variables
ArrayList<Card> hand = new ArrayList<Card>();
//name
String name = "Dealer";
//Dealer or not
public Dealer() {
}

//Hit or stay --
public boolean hitOrStay() {
//Dealer needs to hit until hand total is greater than 16
  if (calculateTotal() > 16) {
    return false;
  }
  else {
    return true;
  }
}

public void hit(Card c) {
//Add card to the player hand
hand.add(c);
}

public void showFirstCard() {
//Dealer should reveal the first card in their hand
//2nd card is hidden
System.out.println("The dealer's first card is: " + hand.get(0));
}

public void revealCards() {
//Shows all cards once done
System.out.println("The dealer's hand is: " + hand);
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
}
