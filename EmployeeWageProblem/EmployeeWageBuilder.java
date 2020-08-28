/* PURPOSE: Calculates wages for multiple companies in Procedural way using CLASS methods */

public class EmployeeWageBuilder {
	
	//CONSTANTS
	public static final int IS_FULL_TIME=2;
	public static final int IS_PART_TIME=1;  
	
	//STATIC METHOD
	public static void computeWage(String company,int empRatePerHour,int maxWorkingDays,int maxMonthlyHours) {

		//VARIABLES
		int workHours=0;
		int totalWorkHours=0;
		int totalWorkingDays=0;

		//while loop to calculate work hours for each day until either 100hours are done or 20 days are reached
		while (totalWorkHours <= maxMonthlyHours && totalWorkingDays <maxWorkingDays) {

			totalWorkingDays++;                     			       //Increment working days logged till now
			int attendanceStatus=(int) Math.floor(Math.random() * 10) % 3;         //Get attendance

			switch (attendanceStatus) {             			       //Condition check for attendance duration

				case IS_FULL_TIME:
					workHours=8;
					break;
				case IS_PART_TIME:
					workHours=4;
					break;
				default:
					workHours=0;
			}

			totalWorkHours+=workHours;  	                           		//total working hours logged upto current day
			System.out.println("Day number: "+ totalWorkingDays + "  Emp Hr: "+ workHours);

		}

		int totalEmpWage=totalWorkHours * empRatePerHour;                               //Calculate month's wages
		System.out.println("Total employee wage for "+company+" is "+totalEmpWage);     //Print final monthly wage with company name

	}
	
	public static void main(String[] args) {
	
		computeWage("DMart",20,2,10);                                                   //call to static method that computes monthly wages for companies
		computeWage("BigBasket",10,4,20);
	}

}



