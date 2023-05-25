/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 11 <br>
 * Due 4/17/2023 10:30am <br>
 * 
 * Purpose:	contains the nessisary methods to create an manipulate a stack
 * 
 * Inputs: card, nodes
 * 
 * Outputs: newCard/data, nodes, stack
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class StackBergeron {
private NodeBergeron myTop;

/**
 * null constructor
 */
public StackBergeron() {
	myTop=null;
}//stack

/**
 * checks if its full
 * @return false because cannot be true
 */
public boolean isFull() {
	return(false);
}//isFull

/**
 * returns if myTop is null
 * @return if myTop is null
 */
public boolean isEmpty() {
	return(myTop==null);
}//isEmpty

/**
 * returns true if pushing card is true
 * @param newCard card object passed through method
 * @return if pushing card is true
 */
public boolean push(CardBergeron newCard) {
	NodeBergeron newGuy=null;
	boolean ans=false;
	if(!isFull()) {
		ans=true;
		newGuy=new NodeBergeron(newCard);
		newGuy.setNext(myTop);
		myTop=newGuy;
	}//if
	return ans;
}//newCard

/**
 * popes the top of the stack
 * @return the card that was just popped
 */
public CardBergeron pop() {
	CardBergeron ans=null;
	if(!isEmpty()) {
		ans=myTop.getData();
		myTop=myTop.getNext();
	}//if
	return ans;
}//pop

}//StackBergeron
