import java.util.Scanner; 

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement_Planner {

	public static void main(String[] args) {
		//Define variables for use with imported finance library jars
		double p;
		double f;
		double n;
		double y;
		double r;
		boolean t;
		
		//Print welcome message
		System.out.println("Welcome to the Java retirement planner!");
		
		Scanner input = new Scanner(System.in);
				
		//Ask for number of years to be worked
		System.out.println("\nEnter the number of years you plan to work: ");
		//Get user input
		double years_worked = input.nextDouble();
		
		//Ask for annual rate return while employed
		System.out.println("\nEnter the average rate of return on investment while employed: ");
		//Get user input
		double employed_return_rate = input.nextDouble();
		
		//Ask for number of years to be retired
		System.out.println("\nEnter the number of years you want to retire for: ");
		//Get user input
		double years_retired = input.nextDouble();
		
		//Ask for desired monthly income upon retirement
		System.out.println("\nEnter desired monthly income upon retirement: ");
		//Get user input
		double retired_income = input.nextDouble();
			
		//Ask for projected monthly SSI 
		System.out.println("\nEnter the your projected monthly SSI upon retirement: ");
		//Get user input
		double SSI = input.nextDouble();
		
		//Ask for projected average rate of return on investment during payback
		System.out.println("\nEnter the average rate of return on investment during payback:");
		//Get user input
		double retired_return_rate = input.nextDouble();
		input.close();
		//Calculate total amount needed to retire
		double PV;
		f = 0;
		n = (12*years_retired);
		y = (retired_income - SSI);
		r = (retired_return_rate/12);		
		t = false;
		
		//Display results
		PV = FinanceLib.pv(r, n, y, f, t);
		System.out.printf("\nYou need to save a total of: %$.2f", PV);
		
		//Calculate monthly payments into retirement fund
		double PMT;
		p = 0;
		f = PV;
		n = (12*years_worked);
		r = (employed_return_rate)/12;
		t = false;
		
		//Display results
		PMT = FinanceLib.pmt(r, n, p, f, t);
		System.out.printf("\nYou need to save a total of: %$.2f", PMT);
		
	
	}
}

