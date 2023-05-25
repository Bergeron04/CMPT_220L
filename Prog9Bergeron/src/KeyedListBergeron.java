/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 9 <br>
 * Due 4/6/2023 10:30am <br>
 * 
 * Purpose: this provides a simple solution for managing a cart of items. It allows the user to perform operations such as adding items to cart, 
 * items in cart and talling quantity, calculating the total cost of all items in the cart, then displaying them.
 * 
 * Inputs: items, lists/carts
 * 
 * Outputs: invalid inputs, sucess/failure of adding item, empty, full, number of items, total cost, details of cart
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class KeyedListBergeron {
ItemBergeron[] myList;
private int mySize;

	/**
	 * null constructor
	 */
	public KeyedListBergeron() {
		myList = new ItemBergeron[10];
		for(int p = 0;p < myList.length;p++)
			myList[p]=null;
		mySize = 0;
	}//KeyedListBergeron
	
	/**
	 * clears the list
	 */
	public void clear() {
		mySize=0;

	}//clear
	
	/**
	 * returns where item was found in list if at all
	 * @param keyValue name of item
	 * @return returns where item was found in list if at all
	 */
	private int findIndex(String keyValue) {
		int index = -1;
		int i = 0;
		while(index == -1 && i < mySize)
			if(myList[i].getKey().equalsIgnoreCase(keyValue))
				index=i;
			else i++;
		return index;
	}//findIndex
	
	/**
	 * adds item to keyed list
	 * @param product new product from user
	 * @return returns if successfull or not
	 */
	public boolean add(ItemBergeron product) {
		boolean success=false;
		int insertIndex = mySize;
		int i = 0;
		if (isFull() || findIndex(product.getKey()) != -1) {
	    }//ifqke
		else {
	    while(i < mySize&&success==false) {
	        if (product.getKey().compareToIgnoreCase(myList[i].getKey()) < 0) {
	            insertIndex = i;
	            success=true;
	        }//if
	        i++;
	    }//while
	    for (i = mySize; i > insertIndex; i--) {
	        myList[i] = myList[i - 1];
	    }//for
	    myList[insertIndex] = product;
	    mySize++;
	    success=true;
		}//else
	    
	    return success;
	}//add
	
	/**
	 * removes item from keyed list
	 * @param keyValue name of item
	 * @return	returns if success in removing item from keyed list or not
	 */
	public boolean remove(String keyValue) {
		boolean success = false;
		int location = findIndex(keyValue);
		if(mySize>0 && location!=-1) {
			for(int i = location+1; i<mySize;i++) {
				myList[i-1] = myList[i];
			}//for
			mySize--;
			success = true;
		}//if
		return success;
	}//remove
	
	/**
	 * returns index of item in list
	 * @param keyValue	name of item
	 * @return index of item in list
	 */
	public ItemBergeron retrieve(String keyValue) {
		ItemBergeron found = null;
		int location = findIndex(keyValue);
		if(location != -1)
			found = myList[location];
		return found;
	}//retrieve
	
	/**
	 * checks if list is empty
	 * @return	true if empty, else false
	 */
	public boolean isEmpty() {
		return (mySize==0);
	}//isEmpty
	
	/**
	 * checks if list is full
	 * @return	true if full, else false 
	 */
	public boolean isFull() {
		return (mySize==10);
	}//isFull
	
	/**
	 * prints out all items in list and their data
	 */
	public void print() {
		for(int i =0; i<mySize;i++) {
			System.out.println("Item #"+(i+1)+":\n"+myList[i].toString()+"\n");
		}//for
	}//print
	
	/**
	 * gets quantity of items in list
	 * @return quantity of items in list
	 */
	public int getCount() {
		int count=0;
		for(int i = 0; i < mySize; i++)
			count+=myList[i].getQuantity();
		return count;
	}//getCount
	
	/**
	 * returns total cost of items
	 * @return total cost of items
	 */
	public double calcTotal() {
		double sum=0.0;
		for(int i = 0;i < mySize; i++) {
			sum+=myList[i].getPrice()*myList[i].getQuantity();
		}//for
		return sum;
	}//calcTotal
	
}//KeyedListBergeron