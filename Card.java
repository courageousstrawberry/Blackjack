public class Card {
  
  //Instance variables
  private int value;
  private String name;
  private String suit;
  private boolean faceCard;

  //Constructors
  public Card (int value, String name, String suit){
    this.value = value;
    this.name = name;
    this.suit = suit;
  }

  public Card() {
    value = 0;
    name = null;
    suit = null;
  }

  //Setters
  public int setValue(int newValue){
    if (value > 10){
      this.faceCard = true;
    }
    else {
      this.faceCard = false;
    }
    return this.value = newValue;
  }
  public String setName(String newName){
    return this.name = newName;
  }
  public String setSuit(String newSuit){
    return this.suit = newSuit;
  }

  //Getters
  public int getValue(){
    return this.value;
  }
  public String getName(){
    return this.name;
  }
  public String getSuit(){
    return this.suit;
  }
  public boolean getFaceCard(){
    if (value > 10){
      this.faceCard = true;
    }
    else {
      this.faceCard = false;
    }
    return this.faceCard;
  }
  
  //Return card information in string form
  public String toString() {
    String text = "";
    text += "\nThe value of the card is: " + this.value;
    text += "\nThe name of the card is: " + this.name;
    text += "\nThe suit of the card is: " + this.suit;
    
    if (faceCard == false) {
      text += "\nThe card is not a face card.";
    }
    else if (faceCard == true) {
      text += "\nThe card is a face card.";
    }
    return text;
  }

  //Find out if two cards are the same card
  public boolean equals(Card other) {
    if (this.value == other.value && this.suit == other.suit) {
      return true;
    }
    else {
      return false;
    }
  }

  //Compare the values of two cards
  public int compareTo(Card other) {
    return this.value - other.value;
  }
}