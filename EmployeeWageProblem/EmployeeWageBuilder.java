/* PURPOSE: Calculates wages for a month */

public class EmployeeWageBuilder {
	
	//CONSTANTS
	static final int IS_FULL_TIME=2;
	static final int IS_PART_TIME=1;  
	static final int EMP_RATE_PER_HOUR=20;
	static final int MAX_WORKING_DAYS=20;

	public static void main(String[] args) {
		//VARIABLES
		int workHours=0;
		int empWage=0;
		int totalEmpWage=0;

		for(int day=0; day<MAX_WORKING_DAYS;day++) {
			int attendanceStatus=(int) Math.floor(Math.random() * 10) % 3; //Get attendance 
			switch (attendanceStatus) {		   	              
				case IS_FULL_TIME:
					workHours=8;
					break;
				case IS_PART_TIME:
					workHours=4;
					break;
				default:
					workHours=0;
			}
			empWage=workHours * EMP_RATE_PER_HOUR; 			      		   //wage calculation
			totalEmpWage+=empWage;  				      				   //sum of daily wages upto current day
		
		}
		System.out.println("Employee wage for the month is : "+totalEmpWage);  //Print wage total after 20 days
	}

}




