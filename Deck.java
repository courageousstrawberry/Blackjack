import java.util.ArrayList;
import java.util.Random;

public class Deck {
  //Instance variables
  ArrayList<String> suits = new ArrayList<String>();
  ArrayList<String>names = new ArrayList<String>();
  ArrayList<Integer>values = new ArrayList<Integer>();
  Random rand = new Random();

  //Structure to hold deck
  ArrayList<Card> gameDeck = new ArrayList<Card>();

  //Constructor
  public Deck() {
  createDeck();
  }

  public void createDeck() {
  populateSuits();
  populateNames();
  populateValues();
  //Need to make card objects
  addCardsToDeck();
  }

  public void populateSuits() {
  suits.add("Clubs");
  suits.add("Hearts");
  suits.add("Spades");
  suits.add("Diamonds");
  }
  public void populateNames() {
    names.add("TWO");
    names.add("THREE");
    names.add("FOUR");
    names.add("FIVE");
    names.add("SIX");
    names.add("SEVEN");
    names.add("EIGHT");
    names.add("NINE");
    names.add("TEN");
    names.add("JACK");
    names.add("QUEEN");
    names.add("KING");
    names.add("ACE");
  }
  public void populateValues() {
    for (int i = 2; i < 11; i++){
      values.add(i);
    }
    
    values.add(10);
    values.add(10);
    values.add(10);
    values.add(11);
  }

  public void printDeck() {
    System.out.println("The deck contains " + gameDeck.size() + " cards");
    
    //Go through each card
    for (int i = 0; i < gameDeck.size(); i++){
      Card temp = gameDeck.get(i);
      System.out.println(temp);
    }
  }
  
  public void addCardsToDeck(){
    for (int i = 0; i < suits.size(); i++){
      String currentSuit = suits.get(i);
      for(int j = 0; j < values.size(); j++){
        String name = names.get(j);
        int value = values.get(j);
        Card one = new Card(value, name, currentSuit);
        gameDeck.add(one);
      }
    }
  }

  //Deal Card method
  public Card dealCard() {
    //int randnum;
    Card value = null;
    createDeck();
    //Get a random number in the size of the deck
    //randnum = ((int)Math.random() * gameDeck.size());
    //Get card for random number using .get(index)
    value = gameDeck.get(rand.nextInt(gameDeck.size()));
    //Remove that card from deck
    gameDeck.remove(value);
    //Return the removed card to be use by the game.
    return value;
  }

}