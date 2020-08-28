/*PROGRAM SUMMARY: Refactor to have one EmployeeWageBuilder for multiple companies using INTERFACE approach */

public class EmployeeWageBuilder {
	
	//INSTANCE VARIABLES
	public final String company;
	public final int empRatePerHour;
	public final int maxWorkingDays;
	public final int maxMonthlyHours;
	public int totalEmpWage;
	
	//CONSTRUCTOR
	public EmployeeWageBuilder(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours) {
	
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.maxWorkingDays=maxWorkingDays;
		this.maxMonthlyHours=maxMonthlyHours;
	}
	//INSTANCE METHOD
	public void setTotalWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	
	@Override
	public String toString() {
		return ("Total employee wage for "+company+" is "+totalEmpWage);     //Print final monthly wage with company name
	}
	

}


