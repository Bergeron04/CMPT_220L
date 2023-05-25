//Paul Bergeron
//Prog 12
//Due Date and Time:5/1/23 before 10:30
//
//Purpose: purpose is to use various types of arrays, as well as manipulation of arrays through numbers and grading
//Input: grades, positive and negative numbers, 0's, characters, doubles, integers, choice for menu selection, grades
//
//Output: Averages, numbers below or above averages, grades as well as accomponying letter grades, positive and negative numbers
//Certification of Authenticity: I certify that this lab is entirely my own work

//imports everything required for project
import java.util.*;

public class ArraysBergeron {
	//scanner declaration
	static Scanner kb=new Scanner(System.in);
	
	//main method printing menu and calling methods
	public static void main(String[] args) {
		//variable declaration
		String conversion="";
		char choice='q';
		double placehold=0.0;
		double[] scores=new double[10];
		double[] upTo8=new double[8];
		int count=0;
		boolean success=false;
		int i =0;
		
		//greeting
		System.out.println("Hello and welcome to my Arrays Menu!");
		System.out.println("This program will take in numbers and manipulate them using arrays");
		System.out.print("then output your results in a nice clean fashion.");
		System.out.println();
		
		//prints menu
 		while(choice!='0') {
			System.out.println("\nMenu:\n1) More Positives or More Negatives?\r\n"
					+ "2) Handle Grades\r\n"
					+ "3) How Many Above / Below Average?\r\n"
					+ "0) Quit");
			//gets users menu input
			conversion=kb.next();
			choice=conversion.toUpperCase().charAt(0);
			switch(choice) {
			//exits menu
			case '0':
				System.out.println("Goodbye! Thank you for using my code");
				break;
			case '1':
				upToTen();
				break;
			case '2':
				//gets 10 inputs for array
				for(i = 0;i<10;i++) {
					System.out.println("Please enter the "+(i+1)+" number(10 total):");
					placehold=kb.nextDouble();
					scores[i]=placehold;
				}//for
				//calls helper method
				callHelper1(scores,i);
				break;
			case '3':
				i=0;
				//gets 8 inputs for array
				while(i<8&&success==false) {
					System.out.println("Please enter a number, up to 8 numbers(you are on number "+(i+1)+"), enter a negative to stop:");
					placehold=kb.nextDouble();
					if(placehold>=0) {
						upTo8[i]=placehold;
						count++;
						i++;
					}//if
					else success=true;
				}//for
				//calls helper method
				callHelper2(upTo8, count);
				count=0;
				break;
			default:
				//when user enters not a menu selection informs them of invalid choice and reprompts
				System.out.println("\nInvalid choice!, enter 1,2,3,or 0 to exit");
			}//switch
				
		}//while

	}//main
	
	/**
	 * allows the user to input up to ten numbers into an array
	 */
	public static void upToTen() {
		//variable declaration
		int[] tenNumberArray = new int[10];
		int input=0;
		int i =0;
		boolean success=false;
		//gets user inputs for array up to 10 numbers and stops at 10 or when user enters 0
		while(i<10&&success==false) {
			System.out.println("Please enter number "+(i+1)+", up to 10 numbers, enter 0 to stop:");
			input=kb.nextInt();
			if(input!=0) {
				tenNumberArray[i]=input;
				i++;
			}//if
			else success=true;
		}//for
		//calls method
		morePosOrNeg(tenNumberArray,i);
	}//arrays
	
	/**
	 * takes list of arrays, and checks if there are more positive or negative numbers, or if they are tied
	 * @param passedArray users array passed through
	 * @param size size of array
	 */
	public static void morePosOrNeg(int[] passedArray, int size) {
		//variable declaration
		int positive=0;
		int negative=0;
		if(passedArray[0]==0) {
			System.out.println("\nThere are no numbers entered, thus there cannot be more positive or negative numbers");
		}//if
		else {
			//checks if numbers are positive or negative
			for(int i =0;i<size;i++) {
				if(passedArray[i]>0) {
					positive++;
				}//if
				else if(passedArray[i]<0){
					negative++;
				}//else if
			}//for
			//checks if there are more positive or negative numbers or are tied and prints accordingly
			if(positive>negative) {
				System.out.println("There are more positive than negative numbers, the positive numbers are: ");
				for(int i =0;i<size;i++) {
					if(passedArray[i]>0) {
						System.out.println(passedArray[i]);
					}//if
				}//for
			}//if
			else if(negative>positive) {
				System.out.println("There are more negative than positive numbers, the negative numbers are: ");
				for(int i =0;i<size;i++) {
					if(passedArray[i]<0) {
						System.out.println(passedArray[i]);
					}//if
				}//for
			}//if
			else {
				System.out.println("There is an equal number of positive and negative numbers, so the values in the array are: ");
				for(int i =0;i<size;i++) {
					if(passedArray[i]!=0) {
						System.out.println(passedArray[i]);
					}//if
				}//for
			}//else
		}//else
	}//arrays
	
	/**
	 * helper method that calls returnHighest method and passes array to it
	 * @param passedArray users array passed through
	 * @param size size of array
	 */
	public static void callHelper1(double[] passingArray,int size) {
		//calls method
		returnHighest(passingArray, size);
	}//method
	
	/**
	 * returns the highest score and prints those scores with accompanying grades
	 * @param passedArray users array passed through
	 * @param size size of array
	 */
	public static void returnHighest(double[] passedArray, int size) {
		//variable declaration
		double highestScore=Double.MIN_VALUE;
		//gets highest score from array
		for(int i =0;i<size;i++) {
			if(passedArray[i]>highestScore) {
				highestScore=passedArray[i];
			}//if
		}//for
		//prints highest score
		System.out.println("The highest score is "+highestScore);
		//prints corosponding grade with scores from array
		for(int i =0;i<size ;i++) {
			if(passedArray[i]>=(highestScore-10)) {
				System.out.println("Your score was "+passedArray[i]+" and your grade was an A");
			}//if
			else if(passedArray[i]>=(highestScore-20)) {
				System.out.println("Your score was "+passedArray[i]+" and your grade was a B");
			}//if
			else if(passedArray[i]>=(highestScore-30)) {
				System.out.println("Your score was "+passedArray[i]+" and your grade was a C");
			}//if
			else if(passedArray[i]>=(highestScore-40)) {
				System.out.println("Your score was "+passedArray[i]+" and your grade was a D");
			}//if
			else System.out.println("Your score of "+passedArray[i]+" was failing, your grade is an F");
			
		}//for
	}//method
	
	/**
	 * helper method that passes the array and count to the calcAverage method
	 * @param passedArray users array passed through
	 * @param size size of array
	 */
	public static void callHelper2(double[] passingArray,int sizeOfArray) {
		//calls method
		calcAverage(passingArray, sizeOfArray);
	}//method
	
	/**
	 * calculates the average and how many numbers are greater than or less than said average, using inputs from a previous helper method passing it an array and integer
	* @param passedArray users array passed through
	 * @param size size of array
	 */
	public static void calcAverage(double[] passedArray,int sizeOfArray) {
		//variable declaration
		double sum=0.0;
		double average=0.0;
		int greater=0;
		int lesser=0;
		//check in case of 0 numbers entered
		if(sizeOfArray==0) {
			System.out.println("\nThere are no numbers entered, thus there cannot be an average, or numbers greater than or less than said average");
		}//if
		else {
			for(int i =0;i<sizeOfArray;i++) {
				sum+=passedArray[i];
			}//for
			//calculates average
			average=sum/sizeOfArray;
			System.out.println("The numbers in the array are: ");
			for(int i =0;i<sizeOfArray;i++) {
				if(passedArray[i]>=average)
					greater++;
				else lesser++;
			System.out.println(passedArray[i]);
			}//for
			//average outputs
			System.out.println("The average of numbers in the array are: "+average);
			System.out.println("There are "+greater+" numbers greater than or equal to the average.");
			System.out.println("There are "+lesser+" numbers lesser than the average.");
		}//else


	}//method

}//class
