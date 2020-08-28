/* PURPOSE: Calculates wages till either maximum working hours or days is raeched for a month */

public class EmployeeWageBuilder {
	
	//CONSTANTS
	static final int IS_FULL_TIME=2;
	static final int IS_PART_TIME=1;  
	static final int EMP_RATE_PER_HOUR=20;
	static final int MAX_WORKING_DAYS=20;
	static final int MAX_MONTHLY_HOURS=100;

	public static void main(String[] args) {
	
		//VARIABLES
		int workHours=0;
		int totalWorkHours=0;
		int totalWorkingDays=0;
		
		//while loop to calculate work hours for each day until either 100hours are done or 20 days are reached
		while (totalWorkHours <= MAX_MONTHLY_HOURS && totalWorkingDays <MAX_WORKING_DAYS) {
	
			totalWorkingDays++;							       //Increment working days counter
			int attendanceStatus=(int) Math.floor(Math.random() * 10) % 3; //Get attendance 
	
			switch (attendanceStatus) {		  	               //Condition check for 0 or 1
	
				case IS_FULL_TIME:
					workHours=8;
					break;
				case IS_PART_TIME:
					workHours=4;
					break;
		    	default:
					workHours=0;
	
			}
	
			totalWorkHours+=workHours; //total working hours logged upto current day
			System.out.println("Day number: "+ totalWorkingDays + "  Emp Hr: "+ workHours);    
		
		}
	
		int totalEmpWage=totalWorkHours * EMP_RATE_PER_HOUR; //Calculate month's wages
		System.out.println("Total employee wage for the month : "+totalEmpWage);  //Print final monthly wage 
	}

}





