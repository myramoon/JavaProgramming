/* PURPOSE: Solves using switch case statement */

public class EmployeeWageBuilder {
	
	//CONSTANTS
	static final int IS_FULL_TIME=2;
	static final int IS_PART_TIME=1;  
	static final int EMP_RATE_PER_HOUR=20;

	public static void main(String[] args) {
		//VARIABLES
		int workHours;
		int empWage;

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
		empWage=workHours * EMP_RATE_PER_HOUR; 		   			      //wage calculation
		System.out.println("Employee wage for the day is : "+empWage);
	}

}



