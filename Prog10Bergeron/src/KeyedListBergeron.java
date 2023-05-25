/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 10 <br>
 * Due 4/17/2023 10:30am <br>
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
private NodeBergeron myHead;

	/**
	 * null constructor
	 */
	public KeyedListBergeron() {
		myHead = null;

	}//KeyedListBergeron
	
	/**
	 * clears the list
	 */
	public void clear() {
		myHead=null;

	}//clear
	
	/**
	 * adds item to keyed list
	 * @param product new product from user
	 * @return returns if successfull or not
	 */
	public boolean add(ItemBergeron product) {
		NodeBergeron newNode = new NodeBergeron(product);
		NodeBergeron current =myHead;
		boolean success=true;
		if (myHead ==null ||myHead.getData().getKey().compareToIgnoreCase(product.getKey()) > 0) {
         newNode.setNext(myHead);
         myHead = newNode;
         success=true;
     }//if
		else {
			while (current.getNext()!= null && current.getNext().getData().getKey().compareToIgnoreCase(product.getKey()) < 0) {
				current = current.getNext();
     }//while

		if (current.getNext()== null|| !current.getNext().getData().getKey().equalsIgnoreCase(product.getKey())) {
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			success=true;
		}//if
		}//else
     return success;
	}//add
 
	
	/**
	 * removes item from keyed list
	 * @param keyValue name of item
	 * @return	returns if success in removing item from keyed list or not
	 */
	public boolean remove(String target) {
		boolean success = false;
		NodeBergeron curr=myHead;
		NodeBergeron prev=null;
		 while (!success && curr != null) {
		        if (curr.getData().getKey().equalsIgnoreCase(target)) {
		            if (prev == null) {
		                myHead = curr.getNext();
		            }//if
		            else {
		                prev.setNext(curr.getNext());
		            }//else
		            success = true;
		        }//if
		        else {
		            prev = curr;
		            curr = curr.getNext();
		        }//else
		    }//while
		    return success;
		}//remove

	/**
	 * returns index of item in list
	 * @param keyValue	name of item
	 * @return index of item in list
	 */
	public ItemBergeron retrieve(String keyValue) {
		ItemBergeron found = null;
		NodeBergeron curr=myHead;
		while (found == null && curr != null) {
	        if (keyValue.equalsIgnoreCase(curr.getData().getKey())) {
	            found = curr.getData();
	        }//if
	        else {
	        	curr = curr.getNext();
	        }//else
	    }//while
	    return found;
	}//retrieve
	/**
	 * checks if list is empty
	 * @return	true if empty, else false
	 */
	public boolean isEmpty() {
		return (myHead==null);
	}//isEmpty
	
	/**
	 * checks if list is full
	 * @return	true if full, else false 
	 */
	public boolean isFull() {
		return (false);
	}//isFull
	
	/**
	 * prints out all items in list and their data
	 */
	public void print() {
		int i = 0;
		NodeBergeron curr=myHead;
		while(curr!=null) {
			System.out.println("Item #"+(i+1)+":\n"+curr.getData().toString()+"\n");
			curr=curr.getNext();
			i++;
		}//for
	}//print
	
	/**
	 * gets quantity of items in list
	 * @return quantity of items in list
	 */
	public int getCount() {
		int count=0;
		NodeBergeron curr=myHead;
		while(curr!=null) {
			count+=curr.getData().getQuantity();
			curr=curr.getNext();
		}//while
		return count;
	}//getCount
	
	/**
	 * returns total cost of items
	 * @return total cost of items
	 */
	public double calcTotal() {
		double sum=0.0;
		NodeBergeron curr=myHead;
		while(curr!=null) {
			sum+=curr.getData().getPrice()*curr.getData().getQuantity();
			curr=curr.getNext();
		}//for
		return sum;
	}//calcTotal
	
}//KeyedListBergeron