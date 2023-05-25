import java.util.*;
import java.io.*;
/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 9 <br>
 * Due 4/6/2023 10:30am <br>
 * 
 * Purpose: this provides a simple solution for managing a shopping cart. It allows the user to perform operations such as adding items to a cart, 
 * calculating the total cost, and adding and removing items.
 * 
 * Inputs: menu choice,name,price,quantity
 * 
 * Outputs: menu, invalid inputs, success/failure of adding item, if empty, if full, number of items, total cost, details of items, quit, greeting, goodbye
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class ShoppingDemoBergeron {
static Scanner kb=new Scanner(System.in);
	public static void main(String[] args) {
		//variables
		char choice;
		String placehold;
		String name;
		int quantity;
		double price;
		ItemBergeron userItem;
		KeyedListBergeron shopList = new KeyedListBergeron();
		File file = null;
		Scanner scanner = null;
		int numInputs;
		
		//greeting
		System.out.println("Hello and welcome to my code, this project will be assisting you in the creation and manipulation of a cart");

		//file inputs
		System.out.println("What is the name of the file?");
		placehold=kb.next();
		file = new File(placehold);
		try {
			scanner = new Scanner(file);
			numInputs=scanner.nextInt();
			for(int a=0;a<(numInputs);a++) {
				name=scanner.next();
				quantity=scanner.nextInt();
				price=scanner.nextDouble();
				userItem=new ItemBergeron(name,quantity,price);
				if (shopList.add(userItem)) {
		            System.out.println("Item "+(a+1)+" imported successfully!\n");
		        }//if 
			 else {
		            System.out.println("List is full! Cannot add item.\n");
		        }//else
			}//for
		}//try 
		catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
			scanner=new Scanner("");
		}//catch
	
			
		do {
			//prints menu
		System.out.println("\n\n1. Add an item to the list\r\n"
				+ "2. Delete an item from the list\r\n"
				+ "3. Print each item in the list\r\n"
				+ "4. Search for a user-specified item in the list\r\n"
				+ "5. Count the total number of items in the list\r\n"
				+ "6. Total the cost of the items in the list\r\n"
				+ "7. Determine whether the list is empty\r\n"
				+ "8. Determine whether the list is full\r\n"
				+ "9. Clear the list\r\n"
				+ "0. Quit");
		
		//gets character
		placehold=kb.next().toUpperCase();
		choice=placehold.charAt(0);
		
		//fulfills menu options
		switch(choice) {
		//adds song
		case '1':
			System.out.println("Please enter the name of the item: ");
			name = kb.next();
			
			System.out.println("Please enter the quantity of the item: ");
			quantity = kb.nextInt();
			while(quantity<=0) {
				System.out.println("Please enter a positive number");
				quantity=kb.nextInt();
			}//while
			
			System.out.println("Please enter the price of the item: ");
			price = kb.nextDouble();
			while(price<=0) {
				System.out.println("Please enter a positive number");
				price=kb.nextDouble();
			}//while
			
			
			userItem=new ItemBergeron(name,quantity,price);
			 if (shopList.add(userItem)) {
		            System.out.println("Item added successfully!\n");
		        }//if 
			 else {
				 if(shopList.isFull())
					 System.out.println("error, list is full");
				 else System.out.println("error, Duplicate");
		        }//else
			break;
			
			//removes item
		case '2':
			System.out.println("What is the name of the item you want to delete?");
			placehold=kb.next();
			if(shopList.remove(placehold))
				System.out.println("item removed succesfully!\n");
			else
				System.out.println(placehold+" is not in the list!\n");
			break;
			
			//prints out list
		case '3':
			if(!shopList.isEmpty())
				shopList.print();
			else System.out.println("There is nothing to print as the list is empty");
			break;
		
			//finds item in list
		case '4':
			System.out.println("What is the name of the item you want to find?");
			placehold=kb.next();
			userItem = shopList.retrieve(placehold);
			if(userItem!=null)
				System.out.println("You have "+userItem.getQuantity()+" "+userItem.getKey()+" at a price of $"+userItem.getPrice()+" each");
			else System.out.println("item not in list");
			break;
			
			//num of items in list
		case '5':
			System.out.println("There are "+shopList.getCount()+" items in the list");
			break;
			
			//prints total cost
		case '6':
			System.out.printf("The total cost of all the items in the list is $%,.2f", shopList.calcTotal());
			break;
			
			//checks for empty
		case '7':
			System.out.println("The list being empty is "+shopList.isEmpty());
			break;
			
			//checks for full
		case '8':
			System.out.println("The list being full is "+shopList.isFull());
			break;
			
			//clears list
		case '9':
			shopList.clear();
			System.out.println("The list has been cleared");
			break;
			
			//quits
		case '0':
			System.out.println("Goodbye! Thank you for using my code!");
			break;
			
			//bad input
		default:
            System.out.println("Invalid choice. Please try again.");
			
		}//switch
		}//do
		while(choice!='0');
		kb.close();
		scanner.close();
	}//main
}//ShoppingDemoBergeron
