/*
Anel Korajkic
Cs110 - Java
4.30.14
This class will actually run the game of war
*/
import java.util.Scanner;
  
public class WarGameTester
{
   public static void main(String [] args)
   {
      int P1Card; //declare variables
      int P2Card;
      int P1Rank;
      int P2Rank;
      int P1WarCard;
      int P2WarCard;
      int P1FaceDown;
      int P2FaceDown;
      int P1WarRank;
      int P2WarRank;
      String P1CardString;
      String P2CardString;
      String P1WarString;
      String P2WarString;
      boolean greater;
      boolean equal;
      WarGame w = new WarGame();
        
      System.out.println("Welcome to the game of War!"); //print a welcome message
        
      w.shuffle(); //shuffle the deck
      w.split(); //split the deck into 2
      Scanner keyboard = new Scanner(System.in); //set up the keyboard
      System.out.print("The deck has been shuffled and split. If you want to play a card press 1: ");
      int answer = keyboard.nextInt(); //see if they want to play
        
      while (answer == 1) //if they pressed 1 play!
      {    
         w.drawTopCard(); //draw the top card
         P1Card = w.getP1Card();
         P2Card = w.getP2Card();
         w.findRankSuit(P1Card);
         P1Rank = w.getRank();
         P1CardString = w.toString();
         w.findRankSuit(P2Card);
         P2Rank = w.getRank();
         P2CardString = w.toString();//set and convert the cards to string
         System.out.printf("Player 1's Card is: %s\n", P1CardString); //print p1's card
         System.out.printf("Player 2's Card is: %s\n", P2CardString); //print p2's card
           
         greater = w.greaterThan(P1Rank, P2Rank); 
         equal = w.equalTo(P1Rank, P2Rank);
         if (greater == true) //if p1 card > p2 they win!
         {
            System.out.println("Player 1 wins the round");
            w.addToPile1();
         }
         else if (greater == false)
         {
            if (equal == true) //if they are equal go to war
            {
               w.warInstance();
               P1FaceDown = w.getFaceDown1();
               P2FaceDown = w.getFaceDown2();
               P1WarCard = w.getWarCard1();
               P2WarCard = w.getWarCard2();
               w.findRankSuit(P1WarCard);
               P1WarRank = w.getRank();
               P1WarString = w.toString();
               w.findRankSuit(P2WarCard);
               P2WarRank = w.getRank();
               P2WarString = w.toString();
               System.out.println("A war! both cards are equal");
               System.out.println("Each player puts 1 card face down and another face up!");
               System.out.printf("Player 1's Card is: %s\n", P1WarString);
               System.out.printf("Player 2's Card is: %s\n", P2WarString);
               greater = w.greaterThan(P1WarRank, P2WarRank);
               if (greater == true)
               {
                  System.out.println("Player 1 wins the war!"); //p1 wins add his winnings to their pile
                  w.addToPile1();
                  w.removeTopCard();
                  w.addToPile1();
                  w.removeTopCard();
                  w.addToPile1();
               }
               else if (greater == false)
               {
                  System.out.println("Player 2 wins the war!"); //p2 wins add his winnings to their pile
                  w.addToPile2();
                  w.removeTopCard();
                  w.addToPile2();
                  w.removeTopCard();
                  w.addToPile2();
               }
            }
            else if (equal == false)
            {
               System.out.println("Player 2 wins the round"); //if p1 < p2, p2 wins
               w.addToPile2();
            }
         }
           
         w.removeTopCard(); //display the remaining deck count
         System.out.printf("Player 1's remaining deck count: %d\n", w.getP1DeckSize());
         System.out.printf("Player 2's remaining deck count: %d\n", w.getP2DeckSize());
              
         if (answer == 1)
         {
            if (w.getP1DeckSize() == 0)
            {
               if (w.getP1PileSize() == 0)
               {
                  System.out.println("Player 2 wins this game of war!"); //if p1 deck and pile are at 0 they lose
                  answer = 2;
               }
               else if (w.getP1PileSize() != 0)
               {
                  w.transferToDeck1();
                  System.out.println("Shuffling... moving Player 1's pile into their deck..."); //shuffle pile into deck
               }
            }
              
            if (w.getP2DeckSize() == 0)
            {
               if (w.getP2PileSize() == 0)
               {
                  System.out.println("Player 1 wins this game of war!"); //if p2 deck and pile are at 0 they lose
                  answer = 2;
               }
               else if (w.getP2PileSize() != 0)
               {
                  w.transferToDeck2();
                  System.out.println("Shuffling.... moving Player 2's pile into their deck..."); //shuffle pile into deck
               }
            }
           
            System.out.println("-------------------------");
              
            if (answer == 1)
            {
               System.out.print("If you want to play a card press 1: "); //see if they want to keep playing
               answer = keyboard.nextInt();
            }
         }
      }
   }
}