/*
Anel Korajkic 
cs110 - Java
4.29.14
This class deals with setting up the rank and suit of a card.

*/

public class Card //We are using integers here to assign to each unique card (IE 22 = Spade 2)
{
   public final int SPADES = 20; //declare variables
   public final int CLUBS = 40;
   public final int DIAMONDS = 60;
   public final int HEARTS = 80;
   private int rank;
   private int suit;
   private String stringSuit;
   private String stringRank;
     
   public void findRankSuit(int cardValue) //we use this to set a single cards rank and suit
   {
      if (cardValue >= 22 && cardValue <= 34)
      {
         rank = cardValue - SPADES;
         suit = SPADES;
      }
        
      else if (cardValue >= 42 && cardValue <= 54)
      {
         rank = cardValue - CLUBS;
         suit = CLUBS;
      }
        
      else if (cardValue >= 62 && cardValue <= 74)
      {
         rank = cardValue - DIAMONDS;
         suit = DIAMONDS;
      }
        
      else if (cardValue >= 82 && cardValue <= 94)
      {
         rank = cardValue - HEARTS;
         suit = HEARTS;
      }
   }
     
   public void setRank(int rank) //setters
   {
      this.rank = rank;
   }
     
   public void setSuit(int suit)
   {
      this.suit = suit;
   }
     
   public int getRank() // getters
   {
      return rank;
   }
     
   public int getSuit()
   {
      return suit;
   }
     
   public String toString() //to string to convert suits to strings
   {
      switch(suit)
      {
         case SPADES:
            stringSuit = "Spades";
            break;
         case CLUBS:
            stringSuit = "Clubs";
            break;
         case DIAMONDS:
            stringSuit = "Diamonds";
            break;
         case HEARTS:
            stringSuit = "Hearts";
            break;
      }
        
      if (rank >= 2 && rank <= 10) // sets rank of card = number if below 11, if above sets a name
      {
         stringRank = String.valueOf(rank);
      }
        
      else if (rank == 11)
      {
         stringRank = "Jack";
      }
        
      else if (rank == 12)
      {
         stringRank = "Queen";
      }
        
      else if (rank == 13)
      {
         stringRank = "King";
      }
        
      else if (rank == 14)
      {
         stringRank = "Ace";
      }
        
      return stringRank + " of " + stringSuit; //formats the output
   }
}