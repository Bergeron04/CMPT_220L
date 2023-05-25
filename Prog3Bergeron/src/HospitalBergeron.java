//Paul Bergeron
//Prog 3
//Due Date and Time:2/9/23 before 10:30
//
//Purpose: Any number of users are unaware of the amount they owe a hospital, and are receiving a bill with the aspects of it layed out for the user in addition to all information they provided. This problem is solved by my program which provides the user with this information neatly layed out in the outputs.
//in addition to summaries at the end with total information such as the highest paid bill
//
//Input: Patient ID number, Household income, insurance plan, number of days
//
//Output: Patient ID number, Household income, insurance plan, number of days, admittance fee, per diem rate, service fee, discount, total bill, number of patients
//highest bill paid, patient id with highest amount associated, total of all bills, average bill amount
//
//Certification of Authenticity: I certify that this lab is entirely my own work

//imports all utilities
import java.util.*;

public class HospitalBergeron {
	//scanner declaration
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		//variable declaration
		char ip;
		double hi=0;
		int nod = 0;
		int pID=-1;
		String cha;
		int cpd=0;
		int sf=0;
		int nop=0;
		double hbp=0;
		int pIDhbp=0;
		double tbp=0;
		double aba=0;
		int disc=0;
		double total=0;
		String insurance="";
		
		//greeting
		System.out.println("Hello and welcome to my Hospital Bill Calculator!");
		System.out.println("This program will take in all of you information such as your patient id number and household income");
		System.out.print("then let you know your total dues and any discounts you may get along the way for as many patients as you would like.");
		System.out.println();
		
		//do while big loop
		while(pID!=0) {
		
			//gets necessary inputs
			System.out.println("\n\nWhat is your patient ID? (Enter 0 to exit): ");
			pID=kb.nextInt();
			if(pID!=0) {
				System.out.println("What is your Household Income: ");
				hi=kb.nextDouble();
				while(hi<0) {
					System.out.println("Please enter a number above 0, What is your household income?: ");
					hi=kb.nextDouble();
				}//while
			
				System.out.println("What is your Insurance plan?: \n'B' for Blue Plus, \n"+ "'M' for Med-Health,\n"+ "'H' for Health Plan, \n"+ "'N' for No Insurance ");
				cha=kb.next().toUpperCase();
				ip=cha.charAt(0);
				while(ip!='B'&&ip!='M'&&ip!='H'&&ip!='N') {
					System.out.println("\nPlease enter one of the 4 characters. What is your Insurance plan?: \n'B' for Blue Plus, \n"+ "'M' for Med-Health,\n"+ "'H' for Health Plan, \n"+ "'N' for No Insurance ");
					cha=kb.next().toUpperCase();
					ip=cha.charAt(0);
				}//while
				switch(ip) {
				case 'B':
					if(hi<14000)
						cpd=40;
					else if(hi<=67500)
						cpd=75;
					else
						cpd=150;
					insurance="Blue Plus";
					break;
				case 'M':
					if(hi<20000)
						cpd=75;
					else if(hi<=50000)
						cpd=100;
					else
						cpd=120;
					insurance="Med-Health";
					break;
				case 'H':
					if(hi<12500)
						cpd=65;
					else if(hi<=63000)
						cpd=80;
					else
						cpd=150;
					insurance="Health Plan";
					break;
				case 'N':
					cpd=500;
					insurance="No Insurnace";
					break;
				}//switch statement
				
				//gets number of days
				System.out.println("How many days did you stay in the hospital?: ");
				nod=kb.nextInt();
				while(nod<1||nod>365) {
					System.out.println("Please enter a number between 1 and 365, How many days did you stay in the hospital?: ");
					nod=kb.nextInt();
				}//while
				//calculates service fee
				sf=cpd*nod;
				
				//calculates discount and total
				total=(250+(sf));
				if(nod>25) {
					disc=(nod/7)*200;
					total-=disc;
				}//if
		
				//total prints and outputs
				System.out.println("\nThe patient ID is: "+pID);
				System.out.printf("The anual household income is: $%.2f", hi);
				System.out.println("\nThe insurnace plan used was: "+insurance);
				System.out.println("The number of days stayed in the hosital was: "+nod+" days");
				System.out.println("The admittance fee was: $250.00");
				System.out.println("The Per diem Rate was: $"+ cpd+".00");
				System.out.println("The service fee was: $"+ sf+".00");
				System.out.println("The discount was: $"+ disc+".00");
				System.out.printf("The total bill is: $%.2f", total);
				
				
				//iterates number of patients
				nop++;
				
				//calculates the total bill paid
				tbp+=total;
				
				//calculates highest bill paid
				if(total>hbp) {
					hbp=total;
					pIDhbp=pID;
				}//if
			}//if
		}//while
			
		//calculates average bill amount	
		aba=tbp/nop;
		
		//final outputs
		System.out.println(nop+" total patient(s) were processed");
		System.out.println("The highest bill paid was $"+hbp);
		System.out.println("The patient id for the highest bill paid was "+pIDhbp);
		System.out.println("The total amount of all bills processed was $"+tbp);
		System.out.println("The average bill ammount was $"+aba);
		
		//goodbye
		System.out.println("\nThank you for using my code! Goodbye!");
		kb.close();	
		}//main
}//HospitalBergeron