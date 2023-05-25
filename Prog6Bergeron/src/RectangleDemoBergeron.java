//Paul Bergeron
//Prog 6
//Due Date and Time:3/1/23 before 10:30
//
//Purpose: create menu that allows the user to input information about a rectangle, see what it and its outline looks like, and see its perimeter and area
//Input: width,height,fill style
//
//Output: width,height,fillstyle,area,perimeter,rectangle,outline of rectangle
//Certification of Authenticity: I certify that this lab is entirely my own work
//
//imports everything required for project
import java.util.*;

//declares class
public class RectangleDemoBergeron {
	//declares scanner
	static Scanner kb = new Scanner(System.in);
	
//start of main
	public static void main(String[] args) {
		//declares variables
		char choice= '0';
		int width=0;
		RectangleBergeron rectangle = new RectangleBergeron();
		int hight=0;
		char fillStyle='*';
		String placeholder="";
		
		//greeting
		System.out.println("Hello and welcome to my Rectangle Demo!");
		System.out.println("This program will take inputs and provide pictures of, as well as data about your chosen rectangle");
		System.out.print("such as area and perimiter.");
		System.out.println();
		
		//starts do/while loops to run menu since menu will run at least once
		do {
			//prints menu
			System.out.println("\nPlease input a character from the menu below:\r\n"
					+ "W : Assign the Width\r\n"
					+ "H : Assign the Height\r\n"
					+ "F : Assign the Fill Style\r\n"
					+ "A : Calculate the Area\r\n"
					+ "P : Calculate the Perimeter\r\n"
					+ "T : Text Description of the Rectangle \r\n"
					+ "D : Draw the Rectangle\r\n"
					+ "O : Draw the Outline of the Rectangle\r\n"
					+ "Q : Quit");
			//gets char of input
			placeholder=kb.next().toUpperCase();
			choice=placeholder.charAt(0);
			
			//switch statement to give user output based on what they input
			switch(choice) {
			
				//assigns the width
			case 'W':
				System.out.println("what would you like to set the width to?: ");
				width=kb.nextInt();
				while(width<1) {
					System.out.println("Please enter a positive number");
					width=kb.nextInt();
				}
				rectangle.setWidth(width);
				break;
			
				//assigns the height
			case 'H':
				System.out.println("what would you like to set the height to?: ");
				hight=kb.nextInt();
				while(hight<1) {
					System.out.println("Please enter a positive number");
					hight=kb.nextInt();
				}
				rectangle.setHeight(hight);
				break;
				
				//assigns fill style
			case 'F':
				System.out.println("what would you like to set the fill area to?: ");
				placeholder=kb.next().toUpperCase();
				fillStyle=placeholder.charAt(0);
				rectangle.setFillStyle(fillStyle);
				break;
				
				//prints area of the rectangle
			case 'A':
				System.out.println("the area of the rectangle is "+rectangle.calcArea());
				break;
				
				//prints perimeter of rectangle
			case 'P':
				System.out.println("the perimiter of the rectangle is "+rectangle.calcPerimeter());
				break;
				
				//prints height/width/area/perimeter of rectangle
			case 'T':
				System.out.println(rectangle.toString());
				System.out.println("The area of the rectangle is "+rectangle.calcArea());
				System.out.println("The perimeterd of the rectangle is "+rectangle.calcPerimeter());
				break;
				
				//draws rectangle in chosen fill style
			case 'D':
				rectangle.drawRectangle();
				break;
				
				//draws outline of rectangle in chosen fill style
			case 'O':
				rectangle.drawOutline();
				break;
				
				//quit
			case 'Q':
				System.out.println("Thank you for using my code! Goodbye!");
				break;
				
				//incase user doesnt enter char in corolation with menu
			default:
				System.out.println("Invalid Input!");
				break;
			}//switch	
		}//while
		while(choice!='Q');

	}//main

}//class
