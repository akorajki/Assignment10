/*
Anel Korajkic
cs110 - Java
4.29.14
This class has the rules of the game of war and actions of the game
*/

import java.util.ArrayList;
  
public class WarGame extends Deck
{
   public int drawnCard1; //all the different forms of cards
   public int drawnCard2;
   public int faceDownCard1;
   public int faceDownCard2;
   public int warCard1;
   public int warCard2;
   public ArrayList<Integer> p1Pile; //both piles for player 1 and 2
   public ArrayList<Integer> p2Pile;
     
   public WarGame() //constructer which sets up player 1 and 2's piles
   {
      p1Pile = new ArrayList<Integer>();
      p2Pile = new ArrayList<Integer>();
   }
        
   public void drawTopCard() //draw the top card (value at index 0)
   {
      drawnCard1 = p1Deck.get(0);
      drawnCard2 = p2Deck.get(0);
      findRankSuit(drawnCard1);
      drawnCard1 = getRank();
      findRankSuit(drawnCard2);
      drawnCard2 = getRank();
   }
     
   public void removeTopCard() //remove the cards that was drawn
   {
      p1Deck.remove(0);
      p2Deck.remove(0);
   }
     
   public void addtoPile1() //adds cards to the p1 pile depending on winner
   {
      p1Pile.add(p1Deck.get(0));
   }
     
   public void addToPile2() //adds cards to to the p2 pile depending on winner
   {
      p2Pile.add(p2Deck.get(0));
   }
     
   public void transferToDeck1() //takes cards from pile 1 and puts them into
   {                             // their respectful deck
      p1Deck.addAll(p1Pile);
      p1Pile.clear();
   }
     
   public void transferToDeck2() //takes cards from pile 2 and puts them into
   {                             // their respectful deck
      p2Deck.addAll(p1Pile);
      p2Pile.clear();
   }
     
   public boolean greaterThan(int card1, int card2) //checks to see if p1's card
   {                                                // is greater than p2's  
      boolean x;
      if (card1 > card2)
      {
         x = true;
      }
        
      else
      {
         x = false;
      }
      return x;
   }
     
   public boolean equalTo(int card1, int card2) //checks to see if p1's card is
   {                                            // equal to p2
   s   
      boolean x;
      if (card1 == card2)
      {
         x = true;
      }
        
      else
      {
         x = false;
      }
      return x;
   }
     
   public void warInstance() // when a war occurs
   {
      faceDownCard1 = p1Deck.get(1);
      faceDownCard2 = p2Deck.get(1);
      warCard1 = p1Deck.get(2);
      warCard2 = p2Deck.get(2);
   }
     
   public int getP1DeckSize() //getters
   {
      return p1Deck.size();
   }
     
   public int getP2DeckSize()
   {
      return p2Deck.size();
   }
     
   public int getP1Card()
   {
      return drawnCard1;
   }
     
   public int getP2Card()
   {
      return drawnCard2;
   }
     
   public int getFaceDown1()
   {
      return faceDownCard1;
   }
     
   public int getFaceDown2()
   {
      return faceDownCard2;
   }
     
   public int getWarCard1()
   {
      return warCard1;
   }
     
   public int getWarCard2()
   {
      return warCard2;
   }
}