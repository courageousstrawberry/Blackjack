public class Game {
//Instance Variables
//Player, Dealer, Deck
Player playerOne;
Dealer dealerOne;
Deck gameDeck;
private int playerTotal;
private int dealerTotal;
private boolean playerBust;
//Constructor
public Game() {
}
//Main game loop
public void play() {
playerBust = false;
//Initialize Deck
gameDeck = new Deck();

/**
The following should be methods that you create to play the game
*/
//Set Player - set name
setPlayer();
setDealer();

//Start game by showing dealer 1st card
dealerOne.showFirstCard();
//Show player cards
playerOne.showHand();
//Ask hit or stay -- returns a boolean
while (playerOne.calculateTotal() <= 21){
  boolean hit = playerOne.hitOrStay();
  if (hit == true){
    playerOne.hit(gameDeck.dealCard());
  }
  else {
    break;
  }
  playerOne.showHand();
  System.out.println(playerOne.calculateTotal());
}

//Continue to give player cards as long as they want or until the bust
if(playerOne.calculateTotal() > 21){
  playerBust = true;
}

//After done hitting or bust - update dealer
while(dealerOne.hitOrStay() == true){
  dealerOne.hit(gameDeck.dealCard());
}

dealerOne.revealCards();
playerTotal = playerOne.calculateTotal();
dealerTotal = dealerOne.calculateTotal();

System.out.println("You're total is: " + playerTotal);

System.out.println("The dealer's total is: " + dealerTotal);

//Determine winner -- update score
winner();

//Exit - continue or end game?
if(playerOne.continueGame() == true) {
  play();
}
else{
  System.exit(0);
}

}

//Add your methods below
public void setPlayer(){
  playerOne = new Player("one");
}

//Set Dealer
public void setDealer(){
  dealerOne = new Dealer();
  dealerOne.hit(gameDeck.dealCard());
}

public void winner(){
  if (playerBust == true) {
    System.out.println("Bust. You loose and the dealer wins.");
  }
  else if(dealerOne.hitOrStay() == true && playerBust == false) {
    System.out.println("You win!");
  }
  else if (playerTotal == dealerTotal) {
    System.out.println("Push! You tied with the dealer.");
  }
  else if (playerTotal > dealerTotal && playerBust == false) {
    System.out.println("You win!");
  }
  else if (dealerTotal > playerTotal && dealerOne.hitOrStay() == false) {
    System.out.println("You loose.. The dealer won.");
  }
}

}
