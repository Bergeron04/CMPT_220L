/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 10 <br>
 * Due 4/17/2023 10:30am <br>
 * 
 * Purpose: this provides a simple solution for managing a cart of items. It creates the nodes in which the itembergeron objects are stored and is the basis for the cart
 * 
 * Inputs: items, nodes
 * 
 * Outputs: items/data, nodes
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class NodeBergeron {
	private ItemBergeron myData;
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
	 * @param newItem passes item object through
	 */
	public NodeBergeron(ItemBergeron newItem) {
		myData=newItem;
	}//NodeBergeron
	
	/**
	 * charges the value of myData instance variable to parameter value
	 * @param newItem passes item object through
	 */
	public void setData(ItemBergeron newItem) {
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
	 * @return returns data of item
	 */
	public ItemBergeron getData() {
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
