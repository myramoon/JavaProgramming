/*PURPOSE: Refactor to have list of multiple companies to manage employee wage */

import java.util.*;

public class WageCalculation implements ComputeWageInterface {

        //CONSTANTS
        public static final int IS_FULL_TIME=2;
        public static final int IS_PART_TIME=1;
        
        //ArrayList declaration
        private ArrayList<EmployeeWageBuilder> companyEmpWageList;

        //DEFAULT CONSTRUCTOR
        public WageCalculation() {
        	companyEmpWageList=new ArrayList<>();
        }

        //INTERFACE IMPLEMENTATION  
        public void addCompanyDetails(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours) {
        	EmployeeWageBuilder companyDetails=new EmployeeWageBuilder(company,empRatePerHour,maxWorkingDays,maxMonthlyHours);
        	companyEmpWageList.add(companyDetails);   					//company details current object added to list
        }
        
        public void computeEmployeeWage() {  							//for each company object, call method that sets total wage for it.
                for (int i=0; i<companyEmpWageList.size(); i++) {
                	EmployeeWageBuilder companyDetails=companyEmpWageList.get(i);
                	companyDetails.setTotalWage(this.computeEmployeeWage(companyDetails));   
                	System.out.println(companyDetails); 
                }
        }
        //INSTANCE METHOD
        private int computeEmployeeWage(EmployeeWageBuilder companyDetails) { 
                //LOCAL VARIABLES
                int workHours=0;
                int totalWorkHours=0;
                int totalWorkingDays=0;

                //COMPUTATION: while loop to calculate work hours for each day until either 100hours are done or 20 days are reached
                while (totalWorkHours <= companyDetails.maxMonthlyHours && totalWorkingDays <companyDetails.maxWorkingDays) {

                        totalWorkingDays++;                                                    //Increment working days logged till now
                        int attendanceStatus=(int) Math.floor(Math.random() * 10) % 3;         //Get attendance

                        switch (attendanceStatus) {                                            //Condition check for attendance duration
                        	case IS_FULL_TIME:
                            		workHours=8;
                            		break;
                        	case IS_PART_TIME:
                            		workHours=4;
                            		break;
                        	default:
                            		workHours=0;

                        }

                totalWorkHours+=workHours;                                           		  //total working hours logged upto current day
                System.out.println("Day number: "+ totalWorkingDays + "  Emp Hr: "+ workHours);

                }
                return totalWorkHours * companyDetails.empRatePerHour;                    	  //Calculate month's wages

        }

        public static void main(String[] args) {
        	ComputeWageInterface companyObject= new WageCalculation();                         	
        	companyObject.addCompanyDetails("DMart",20,2,10);				  //add details of company to linked list	
        	companyObject.addCompanyDetails("Reliance",20,4,20);
        	companyObject.computeEmployeeWage();  	                                          //call to computation method


        }

}

