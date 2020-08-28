/* PROGRAM SUMMARY: Refactor to have one EmployeeWageBuilder for multiple companies using INTERFACE approach */

public class WageCalculation implements ComputeWageInterface {

	//CONSTANTS
	public static final int IS_FULL_TIME=2;
	public static final int IS_PART_TIME=1;  
	//INSTANCE VARIABLES 
	private int companyNumber=0;
	//ARRAY declaration
	private EmployeeWageBuilder[] companyArray;   
	
	
	//DEFAULT CONSTRUCTOR: array object created with size 5
	public WageCalculation() {
		companyArray=new EmployeeWageBuilder[5];   //Array initialized
	} 
	
	//INTERFACE METHODS IMPLEMENTATION
	public void addCompanyDetails(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours) { //create new company object with parameters and store the reference of object in current array index
		companyArray[companyNumber]=new EmployeeWageBuilder(company,empRatePerHour,maxWorkingDays,maxMonthlyHours); 
		companyNumber++;    //increment number of company counter
	}

	public void computeEmployeeWage() {  //for each company object, call method that sets total wage fot it.As parameter,give computed wage of current object.
		for (int i=0; i<companyNumber; i++) {
			companyArray[i].setTotalWage(this.computeEmployeeWage(companyArray[i]));
			System.out.println(companyArray[i]);   //implements according to overridden toString() method  
		}
	}

	//INSTANCE METHOD
	private int computeEmployeeWage(EmployeeWageBuilder wageBuilderElement) {  //called by computeEmployeeWage() with current company object reference as parameter
		//LOCAL VARIABLES
		int workHours=0;
      		int totalWorkHours=0;
      		int totalWorkingDays=0;

        	//COMPUTATION: while loop to calculate work hours for each day until either 100hours are done or 20 days are reached
      		while (totalWorkHours <= wageBuilderElement.maxMonthlyHours && totalWorkingDays <wageBuilderElement.maxWorkingDays) {

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

     	    		totalWorkHours+=workHours;  	                           	      //total working hours logged upto current day
     			System.out.println("Day number: "+ totalWorkingDays + "  Emp Hr: "+ workHours);

        	}
      		return totalWorkHours * wageBuilderElement.empRatePerHour;                    //Calculate month's wages
        
	}

	public static void main(String[] args) {
		ComputeWageInterface wageBuilder= new WageCalculation();			      //create object and initialize to given parameters
		wageBuilder.addCompanyDetails("DMart",20,2,10);
		wageBuilder.addCompanyDetails("Reliance",20,4,20);
		wageBuilder.computeEmployeeWage();					      //call to computation method
		

	}

}

