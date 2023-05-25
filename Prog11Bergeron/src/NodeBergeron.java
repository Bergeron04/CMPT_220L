/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 11 <br>
 * Due 4/17/2023 10:30am <br>
 * 
 * Purpose: contains the nessisary methods to create an manipulate a node
 * 
 * Inputs: card, nodes
 * 
 * Outputs: newCard/data, nodes
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class NodeBergeron {
	private CardBergeron myData;
	 private NodeBergeron myNode;
	
	 /**
	  * null constructor
	  */
	public NodeBergeron() {
		myData=null;
		myNode=null;
	}//NodeBergeron
	
	/**
	 * default constructor
	 * @param newCard passes card object through
	 */
	public NodeBergeron(CardBergeron newCard) {
		myData=newCard;
		myNode=null;
	}//NodeBergeron
	
	/**
	 * charges the value of myData instance variable to parameter value
	 * @param newCard passes card object through
	 */
	public void setData(CardBergeron newItem) {
		myData=newItem;
	}//setData
	
	/**
	 * charges the value of myNode instance variable to parameter value
	 * @param newNode passes node object through
	 */
	public void setNext(NodeBergeron newNode) {
		myNode=newNode;
	}//setNext
	
	/**
	 * method that returns data of the item
	 * @return returns data of a card
	 */
	public CardBergeron getData() {
		return myData;
	}//myData
	
	/**
	 * method that returns node object
	 * @return returns node object
	 */
	public NodeBergeron getNext() {
		return myNode;
	}//getNext
}//NodeBergeron
