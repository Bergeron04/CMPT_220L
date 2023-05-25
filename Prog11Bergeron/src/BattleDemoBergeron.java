/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 11 <br>
 * Due 4/17/2023 10:30am <br>
 * 
 * Purpose: takes a deck of cards, deals them out two players, and plays a game of war.
 * 
 * Inputs: card, nodes
 * 
 * Outputs: newCard/data, nodes
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
import java.io.*;
import java.util.Scanner;

public class BattleDemoBergeron {
public static Scanner kb=new Scanner(System.in);
/**
 * reads from file and deals cards to each individual player
 * @param fileName name of the time
 * @param play1 player 1 deck
 * @param play2 player 2 deck
 */
	public static void deal(String fileName, StackBergeron play1,StackBergeron play2) {
		File file = null;
		Scanner scanner = null;
		file = new File(fileName);
		int number=0;
		String suit;
		int numInputs;
		CardBergeron userCard;
		int evenOdd=0;
		try {
			scanner = new Scanner(file);
			numInputs=scanner.nextInt();
			for(int a=0;a<(numInputs);a++) {
				number=scanner.nextInt();
				suit=scanner.next();
				userCard=new CardBergeron(number,suit);
				if(evenOdd%2==0) {
					play1.push(userCard);
				}//if
				else {
					play2.push(userCard);
				}//else
				evenOdd++;
			}//for
		}//try 
		catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
			scanner=new Scanner("");
		}//catch
		scanner.close();
	}//deal
	
	public static CardBergeron play(StackBergeron deck) {
		return deck.pop();
	}//play
	
	/**
	 * compares the two cards and decides a winner
	 * @param firstCard player 1 card
	 * @param secondCard player 2 card
	 * @return
	 */
	public static CardBergeron compare(CardBergeron firstCard, CardBergeron secondCard) {
		CardBergeron winner;
		if(firstCard.getNum()==secondCard.getNum())
			winner=null;
		else if(firstCard.getNum()>secondCard.getNum())
			winner=firstCard;
		else
			winner=secondCard;
		return winner;
	}//compare
	
	/**
	 * method that deals with what happens once someone wins
	 * @param play1 player 1 deck
	 * @param play2 player 2 deck
	 * @param dis1 player 1 discard
	 * @param dis2 player 2 discard
	 */
	public static void winPlay(StackBergeron play1,StackBergeron play2, StackBergeron dis1,StackBergeron dis2) {
		CardBergeron card1 = null;
		CardBergeron card2 = null;
		CardBergeron winner = null;
		if(!play1.isEmpty()&&!play2.isEmpty()) {
			card1=play(play1);
			card2=play(play2);
			winner=compare(card1,card2);
			if(winner==null) {
				dis1.push(card1);
				dis2.push(card2);
			}//if
			else if(winner==card1) {
					dis1.push(card1);
					dis1.push(card2);
			}//if
			else {
				dis2.push(card2);
				dis2.push(card1);
			}//else
		}//if
	}//winPlay

	/**
	 * copy discard to the main deck 
	 * @param deck temporary deck
	 * @return the new deck
	 */
	public static void copy(StackBergeron deck, StackBergeron deck2) {
		StackBergeron temp=new StackBergeron();
		CardBergeron popped=null;
		while(!deck.isEmpty()) {
			popped=deck.pop();
			temp.push(popped);
		}//while
		while(!temp.isEmpty()) {
			popped=temp.pop();
			deck2.push(popped);
			System.out.println(popped.getNum()+" was popped");
		}//while
	}//copy
	
	/**
	 * counts number of cards in a deck
	 * @param deck deck object passed through
	 * @return the number of cards in a deck
	 */
	public static int countCards(StackBergeron deck) {
		int total = 0;
		StackBergeron temp=new StackBergeron();
		CardBergeron popped = null;
		while(!deck.isEmpty()) {
			popped=deck.pop();
			temp.push(popped);
			total++;
		}//while
		while(!temp.isEmpty()) {
			popped=temp.pop();
			deck.push(popped);
		}//while
		return total;
	}//countCards
	
	/**
	 * returns summary of the game
	 * @param play1 player 1 deck
	 * @param play2 player 2 deck
	 * @param plays number of plays
	 * @param disc1 discard of the first deck
	 * @param disc2 discard of the second deck
	 * @return summary of game
	 */
	public static String printResults(StackBergeron play1, StackBergeron play2, int plays,StackBergeron disc1,StackBergeron disc2) {
		String ans="Battle Card Game Summary\r\n"
				+ "========================\r\n"
				+ "The game started with "+(countCards(play1)+countCards(play2))+" cards.\r\n"
				+ "There were "+plays+" plays in the game.\r\n";
		if(play1.isEmpty()&&play2.isEmpty()) {
			ans =  "The game ended with a no clear.\r\n"
					+ "Player 1 ended up with 0 cards.\r\n"
					+ "Player 2 ended up with 0 cards.\r\n"
					+ "There was no winner";
		}//if
		else if(play2.isEmpty()) {
			ans = "The game ended with a clear winner.\r\n"
				+ "Player 1 ended up with "+countCards(play1)+" cards.\r\n"
				+ "Player 2 ended up with 0 cards.\r\n"
				+ "The winner was Player 1";
	}//else if
		else if(play1.isEmpty()) {
			ans =  "The game ended with a clear winner.\r\n"
					+ "Player 1 ended up with 0 cards.\r\n"
					+ "Player 2 ended up with "+countCards(play2)+" cards.\r\n"
					+ "The winner was Player 2";
		}//else if
		else {
			ans = "The game ended with no clear winner.\r\n"
					+ "Player 1 ended up with "+(countCards(play1)+countCards(disc1))+" cards.\r\n"
					+ "Player 2 ended up with "+(countCards(play2)+countCards(disc2))+" cards.\r\n"
					+ "The winner was no one";
		}//else
		return ans;
	}//print results
	
	public static void main(String[] args) {
		//variable declaration
		StackBergeron deck1 = new StackBergeron();
		StackBergeron deck2 = new StackBergeron();
		StackBergeron discard1 = new StackBergeron();
		StackBergeron discard2 = new StackBergeron();
		int i = 0;
		String nameOfFile;
		//gets file name for import
		System.out.println("What is the name of the file?");
		nameOfFile=kb.next();
		//deals cards
		deal(nameOfFile,deck1,deck2);
		//plays game
		while(i<1000&&!deck1.isEmpty()&&!deck2.isEmpty()) {
		winPlay(deck1,deck2,discard1,discard2);
		if(deck1.isEmpty()) {
			copy(discard1,deck1);
			System.out.println("player 1 discard copyd");
		}//if
		if (deck2.isEmpty()) {
			copy(discard2,deck2);
			System.out.println("player 2 discard copyd");
		}//if
		i++;
		}//while
		//prints results
		System.out.println(printResults(deck1,deck2,i,discard1,discard2));
		
		
	}//main

}//class
