/* PURPOSE: Refactor to have list of multiple companies to manage employee wage */

public interface ComputeWageInterface {
	
	public void addCompanyDetails(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours);
	public void computeEmployeeWage();
	
}
