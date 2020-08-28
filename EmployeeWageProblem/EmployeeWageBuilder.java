/* PURPOSE: Calculates and saves totalwages for multiple companies  using instance variables */

public class EmployeeWageBuilder {
	
	//CONSTANTS
	public static final int IS_FULL_TIME=2;
	public static final int IS_PART_TIME=1;  
	
	//INSTANCE VARIABLES
	private final String company;
	private final int empRatePerHour;
	private final int maxWorkingDays;
	private final int maxMonthlyHours;
	private int totalEmpWage;
	
	//CONSTRUCTOR
	public EmployeeWageBuilder(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours) {
	
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.maxWorkingDays=maxWorkingDays;
		this.maxMonthlyHours=maxMonthlyHours;
	}
	
	//INSTANCE METHOD
	public void computeWage() {

		//LOCAL VARIABLES
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

      	totalEmpWage=totalWorkHours * empRatePerHour;  	                                //Calculate month's wages

	}
	
	@Override
	public String toString() {
		return ("Total employee wage for "+company+" is "+totalEmpWage);       //Print final monthly wage with company name
	}
	
	public static void main(String[] args) {
	
		//Create two company objects
		EmployeeWageBuilder Company1= new EmployeeWageBuilder("DMart",20,2,10);
		EmployeeWageBuilder Company2= new EmployeeWageBuilder("Reliance",30,4,12);
		
		//Call instance method "computeWage" that computes monthly wages for companies for these objects
		Company1.computeWage();
		System.out.println(Company1);  					       
		Company2.computeWage();
		System.out.println(Company2);
	}

}


