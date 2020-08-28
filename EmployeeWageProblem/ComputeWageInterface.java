/*PURPOSE: Refactor to get total wage when queried by company */

public interface ComputeWageInterface {
	
	public void addCompanyDetails(String company,int empRatePerHour, int maxWorkingDays, int maxMonthlyHours);
	public void computeEmployeeWage();
	public int getTotalWage(String company);	
}
