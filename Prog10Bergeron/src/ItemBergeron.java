/**
 * 
 * @author paulbergeron <br>
 * 
 * Prog 10 <br>
 * Due 4/17/2023 10:30am <br>
 * 
 * Purpose: this provides a simple solution for managing a shopping cart of items. It allows the user to perform operations such as adding items to cart, 
 * editing their values, and displaying them
 * 
 * Inputs: name/key,price,quantity
 * 
 * Outputs: name/key,price,quantity
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 * test edit
 *
 */
public class ItemBergeron {
private String myKey;
private int myQuantity;
private double myPrice;

	/**
	 * null constructor.
	 */
	public ItemBergeron() {
		myKey="";
		myQuantity=0;
		myPrice=0.0;
	}//itemBergeron
	
	/**
	 *default constructor
	 * @param newKey name of item
	 * @param newQuantity quantity of item
	 * @param newPrice price of item
	 */
	public ItemBergeron(String newKey,int newQuantity, double newPrice) {
		myKey=newKey;
		myQuantity=newQuantity;
		myPrice=newPrice;
	}//itemBergeron
	
	/**
	 * charges the value of myKey instance variable to parameter value
	 * @param newKey name of item
	 */
	public void setKey(String newKey) {
		myKey=newKey;
	}//setName
	
	/**
	 * charges the value of myQuantity instance variable to parameter value
	 * @param newQuantity	quantity of item
	 */
	public void setQuantity(int newQuantity) {
		myQuantity=newQuantity;
	}//setQuantity
	
	/**
	 * charges the value of myPrice instance variable to parameter value
	 * @param newPrice	price of item
	 */
	public void setPrice(double newPrice) {
		myPrice=newPrice;
	}//setPrice
	
	/**
	 * method that returns name of the item
	 * @return returns name of item
	 */
	public String getKey() {
		return myKey;
	}//getPrice
	
	/**
	 * method that returns quantity of the item
	 * @return returns quantity of item
	 */
	public int getQuantity() {
		return myQuantity;
	}//getPrice
	
	/**
	 * method that returns price of the item
	 * @return method that returns price of the item
	 */
	public double getPrice() {
		return myPrice;
	}//getPrice
	
	/**
	 * prints out all data about item
	 */
	public String toString() {
		String ans= "\nThe key/name of the item is "+myKey;
		ans+= "\nThe quantity of the item is "+myQuantity;
		ans+= "\nThe price of the item is $"+String.format("%.2f", myPrice);
		return ans;
	}//toString
}//ItemBergeron
