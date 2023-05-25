//Paul Bergeron
//Prog 4
//Due Date and Time:2/16/23 before 10:30
//
//Purpose: to learn about methods and to continue to master conditional statements and loops, as well as to calculate the number of movies, their price, as well as total costs and output them to the user
//
//Input: customer id, customer name, number of movies, movie length, and movie rating
//
//Output: number of customers, highest amount and id associated, lowest amount and id associated, total amount of downloads, average, customer name, movies purchased, service charge, total ammount including taxes
//
//Certification of Authenticity: I certify that this lab is entirely my own work

//imports everything required for project
import java.util.*;
public class MoviesBergeron {
	//scanner declaration
	static Scanner kb=new Scanner(System.in);
	public static void main(String[] args) {
		//variable declaration for project
		int customerId = 0;
        String customerName = "";
        int numOfMovies = 0;
        double totalCost = 0.0;
        int numCustomers = 0;
        double highestAmount = 0.0;
        int highestCustomerId = 0;
        double lowestAmount = Double.MAX_VALUE;
        int lowestCustomerId = 0;
        double totalAmount = 0.0;
        double averageAmount = 0.0;
        

		//greeting
		System.out.println("Hello and welcome to my Movie Calculator!");
		System.out.println("This program will take in all of you information such as your customer id number, name, and number of movies bought, ");
		System.out.print("then let you know your total cost overall and per person.");
		System.out.println();
        
        //getting all required inputs for main
        System.out.println("Please enter the customer ID(0 to exit): ");
        customerId=kb.nextInt();
        while(customerId!=0) {
	        System.out.println("Please enter the customer name: ");
	        customerName=kb.next();
	        
	        System.out.println("How many movies were ordered?: ");
	        numOfMovies=kb.nextInt();
	        while(numOfMovies<0) {
	        	System.out.println("Please enter a positive integer! How many movies were ordered?: ");
	            numOfMovies=kb.nextInt();
	        }//while
	        
	        //calculating total costs of all movies as well as their fees and final amount due
	        totalCost = chooseMovies(numOfMovies);
	        double serviceCharge = calcServiceCharge(numOfMovies, totalCost);
            double totalDue = calcTotalDue(totalCost, serviceCharge);
	        numCustomers++;
	        //calculate total amounts and checking vs current amount and previous highest id and amount
	        totalAmount += totalDue;
            if (totalDue > highestAmount) {
                highestAmount = totalDue;
                highestCustomerId = customerId;
            }//if
            if (totalDue < lowestAmount) {
                lowestAmount = totalDue;
                lowestCustomerId = customerId;
            }//if
            //calculating average amount of cost of movies
            averageAmount = totalAmount / numCustomers;
            
	        outputResults(customerName, customerId, numOfMovies, totalCost, serviceCharge, totalDue);

            //getting customer id
	        System.out.println("\nPlease enter the customer ID(0 to exit): ");
	        customerId=kb.nextInt();
        }//while
        //output summary with all final variables
        System.out.println("Summary:");
        System.out.println("Number of customers processed: "+ numCustomers);
        System.out.printf("Highest amount charged: $%.2f%n", highestAmount);
        System.out.println("The Patient id with the highest ammount is: "+highestCustomerId);
        if(numCustomers==0)
        	System.out.println("Lowest amount charged: $0.00");
        else System.out.printf("Lowest amount charged: $%.2f%n", lowestAmount);
        System.out.println("The Patient id with the lowest ammount is: "+lowestCustomerId);
        System.out.printf("Total amount of downloads purchased: $%.2f%n", totalAmount);
        if(numCustomers==0)
        	System.out.println("There is no average to display due to there being no customers");
        else System.out.printf("Average purchase amount: $%.2f%n", averageAmount);
        
        System.out.println("\nThank you for using my code! Goodbye!");
		kb.close();
	}//main
	//method for calculating length and rating a movie and corolating price
	public static double chooseMovies(int numMovies) {
		double totalCost=0.0;
		//looping equal to number of movies declared by user
		for (int i = 1; i <= numMovies; i++) {
			int movieLength=0;
			char rating;
			String placehold;
			double costPerMinute=0.0;
			
			System.out.println("\nHow long is the movie(in min)?: ");
			movieLength=kb.nextInt();
	        while(movieLength < 1 || movieLength > 240) {
	        	System.out.println("\nPlease enter a number between 1 and 240! How long is the movie(in min)?: ");
	            movieLength=kb.nextInt();
	        }//while
	        //getting rating and verifying valid input
	        System.out.print("\nEnter the rating (G, P, R, X, or O): ");
	        placehold = kb.next().toUpperCase();
	        rating=placehold.charAt(0);
	        while(rating!='G'&&rating!='P'&&rating!='R'&&rating!='X'&&rating!='O') {
	        	System.out.print("\nInvalid Input! Please enter the rating (G, P, R, X, or O): ");
	        	rating=kb.next().toUpperCase().charAt(0);
	        }//while
	        //calculating price per each rating
	        switch(rating) {
	        	case 'G':
	        		costPerMinute=.048;
	        		break;
	        	case 'P':
	        		costPerMinute=.062;
	        		break;
	        	case 'R':
	        		costPerMinute=0.073;
	        		break;
	        	case 'X':
	        		costPerMinute=.273;
	        		break;
	        	case 'O':
	        		costPerMinute=.05;
	        		break;
	        }//switch
	        totalCost+=costPerMinute*movieLength;
	        		
		}//for
		return totalCost;
	}//method
	//method for calculating the service charge
	public static double calcServiceCharge(int numberMovies, double totalsCost) {
		//variable declaration
		double serviceFee=0.0;
		//checking number of movies against a number to calculate service charge
		if (numberMovies >= 1 && numberMovies <= 3) {
	        serviceFee = 0.15 * totalsCost;
	    } //if
		else if (numberMovies >= 4 && numberMovies <= 7) {
	        serviceFee = 0.12 * totalsCost;
	    } //else if
		else if (numberMovies >= 8 && numberMovies <= 11) {
	        serviceFee = 0.09 * totalsCost;
	    } //else if
		else {
	        serviceFee = 0.06 * totalsCost;
	    }//else if
		return serviceFee;
	}//method
	
	//method to calculate the total amount due
	public static double calcTotalDue(double totalsCost,double serviceFee) {
		//calculate tax and total due
		double tax = 0.08 * (totalsCost + serviceFee);
	    double totalDue = totalsCost + serviceFee + tax;
		return totalDue;
	}//method
	
	//method to give all general outputs for program
	public static void outputResults(String name, int id,int numberMovies,double movieCost,double serviceFee,double totalsAmount ) {
		//prints name,id,number of movies,ect...
		System.out.println("\nCustomer Name: " + name);
	    System.out.println("Customer ID: " + id);
	    System.out.println("Number of Movies Purchased: " + numberMovies);
	    System.out.printf("Total Cost of Movies: $%.2f\n", movieCost);
	    System.out.printf("Service Charge: $%.2f\n", serviceFee);
	    System.out.printf("Total Amount Due (including tax): $%.2f\n", totalsAmount);	
	}//method
}//class
