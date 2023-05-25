/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 11 <br>
 * Due 4/17/2023 10:30am <br>
 * 
 * Purpose: contains the nessisary methods to create an manipulate a card
 * 
 * Inputs: card, nodes
 * 
 * Outputs: newCard/data, nodes
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class CardBergeron {
int myNum;
String mySuit;

/**
 * creates card object with number and suit of card
 * @param newNum sets number of card
 * @param newSuit suits suit of a card
 */
public CardBergeron(int newNum, String newSuit) {
	mySuit=newSuit;
	myNum=newNum;
}//cardBergeron

/**
 * sets suit of a card
 * @param newSuit sets new suit of a card
 */
public void setSuit(String newSuit) {
	mySuit=newSuit;
}//setSuit

/**
 * sets new value of a card
 * @param newNum sets numbers vale
 */
public void setNum(int newNum) {
	myNum=newNum;
}//setNum

/**
 * returns suit of card
 * @return suit of card
 */
public String getSuit() {
	return mySuit;
}//getPrice

/**
 *  returns number
 * @return number
 */
public int getNum() {
	return myNum;
}//getPrice

}//CardBergeron
