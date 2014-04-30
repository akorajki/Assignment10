/*
Anel Korajkic
cs110 - Java
4.29.14
This class sets up the decks (shuffling and splitting)
*/

import java.util.Random;
import java.util.ArrayList;
  
public class Deck extends Card
{
   public static int FULL_DECK = 52; //size of the full deck
   public static int HALF_OF_DECK = 26; // size of half the deck
   public ArrayList<Integer> deck; //make the decks into array lists
   public ArrayList<Integer> p1Deck;
   public ArrayList<Integer> p2Deck;
   public int [] suits = {20, 40, 60, 80}; //set up suit array
   public int [] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; //set up rank array
   public Random rand;
     
     
   public Deck() //Sets up the whole deck
   {
      rand = new Random();
      deck = new ArrayList<Integer>();
      p1Deck = new ArrayList<Integer>();
      p2Deck = new ArrayList<Integer>();
      for (int r = 0; r < ranks.length; r++)
      {
         for (int s = 0; s < suits.length; s++)
         {
            deck.add(ranks[r] + suits[s]);
         }
      }
   }
     
   public void shuffle() //shuffle the decks
   {
      int randNum;
      int temp;
      Random r = new Random();
      for (int i = 0; i < FULL_DECK; i++)
      {
         randNum = r.nextInt(FULL_DECK);
         temp = deck.get(i);
         deck.set(i, Integer.valueOf(deck.get(randNum)));
         deck.set(randNum, Integer.valueOf(temp));
      }
   }
     
   public void split() //split the deck into 2
   {
      for (int i = 0; i < HALF_OF_DECK; i++)
      {
         p1Deck.add(deck.get(i));
      }
        
      for (int i = 0; i < HALF_OF_DECK; i++)
      {
         p2Deck.add(deck.get(i + HALF_OF_DECK));
      }
   }
     
   public ArrayList<Integer> getDeck() //getters
   {
      return deck;
   }
     
   public ArrayList<Integer> getP1Deck()
   {
      return p1Deck;
   }
     
   public ArrayList<Integer> getP2Deck()
   {
      return p2Deck;
   }
}