//Paul Bergeron
//Prog 2
//Due Date and Time:2/2/23 before 10:30
//
//Purpose: The user is unaware of the amount they owe a hospital, and are receiving a bill with the aspects of it layed out for the user in addition to all information they provided. This problem is solved by my program which provides the user with this information neatly layed out in the outputs.
//
//Input: Patient ID number, Household income, insurance plan, number of days
//
//Output: Patient ID number, Household income, insurance plan, number of days, admittance fee, per diem rate, service fee, discount, total bill
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
		int pID=0;
		String cha;
		int cpd=0;
		double total=0;
		int disc=0;
		int sf=0;
		
		//gets necessary inputs
		System.out.println("What is your patient ID: ");
		pID=kb.nextInt();
		
		System.out.println("What is your Household Income: ");
		hi=kb.nextDouble();
		
		System.out.println("What is your Insurance plan?: \n'B' for Blue Plus, \n"+ "'M' for Med-Health,\n"+ "'H' for Health Plan, \n"+ "'N' for No Insurance ");
		cha=kb.next();
		ip=cha.charAt(0);
		switch(ip) {
		case 'B':
			if(hi<14000)
				cpd=40;
			else if(hi<67500)
				cpd=75;
			else if(hi>67500)
				cpd=150;
			break;
		case 'M':
			if(hi<20000)
				cpd=75;
			else if(hi<50000)
				cpd=100;
			else if(hi>50000)
				cpd=120;
			break;
		case 'H':
			if(hi<12500)
				cpd=65;
			else if(hi<63000)
				cpd=80;
			else if(hi>63000)
				cpd=150;
			break;
		case 'N':
			cpd=500;
			break;
		}//switch statement
		
		//gets number of days
		System.out.println("How many days did you stay in the hospital?: ");
		nod=kb.nextInt();
		
		//calculates service fee
		sf=cpd*nod;
		
		//calculates discount and total
		if(nod>25) {
			disc=(nod/7)*450;
			total=(250+(sf)-disc);
		}//if
		else total=(250+(cpd*nod));

		//total prints and outputs
		System.out.println("\nThe patient ID is: "+pID);
		System.out.printf("The anual household income is: $%.2f", hi);
		if(ip=='B')
			System.out.println("\nThe insurance plan used was: Blue Plus");
		else if(ip=='M')
			System.out.println("\nThe insurance plan used was: Med-Health");
		else if(ip=='H')
			System.out.println("\nThe insurance plan used was: Health Plan");
		else if(ip=='N')
			System.out.println("\nNo insurance plan was used");
		System.out.println("The number of days stayed in the hosital was: "+nod+" days");
		System.out.println("The admittance fee was: $250.00");
		System.out.println("The Per diem Rate was: $"+ cpd+".00");
		System.out.println("The service fee was: $"+ sf+".00");
		System.out.println("The discount was: $"+ disc+".00");
		System.out.printf("The total bill is: $%.2f", total);
	}//main

}//class
