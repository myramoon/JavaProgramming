/* PROGRAM SUMMARY: Refactor to have one EmployeeWageBuilder for multiple companies using INTERFACE approach */

public interface ComputeWageInterface {
	
	public void addCompanyDetails(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours);
	public void computeEmployeeWage();
	
}
