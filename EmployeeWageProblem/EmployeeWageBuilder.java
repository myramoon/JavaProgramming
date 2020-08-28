public class EmployeeWageBuilder {
	
	//CONSTANTS
	static final int IS_FULL_TIME=1;  
	static final int EMP_RATE_PER_HOUR=20;
	
	public static void main(String[] args) {

		//VARIABLES
		int workHours;
		int empWage;

		int attendanceStatus=(int) Math.floor(Math.random() * 10) % 2; //Get attendance as 0 or 1 for absent and present respectively
		if (attendanceStatus == IS_FULL_TIME)			       //Condition check for 0 or 1
			workHours=8;
		else
			workHours=0;

		empWage=workHours * EMP_RATE_PER_HOUR; 				//wage calculation
		System.out.println("Employee wage for the day is : "+empWage);

	}

}

