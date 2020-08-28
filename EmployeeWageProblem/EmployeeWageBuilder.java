public class EmployeeWageBuilder {

	static final int IS_FULL_TIME=1;  //CONSTANT

	public static void main(String[] args) {
		int attendanceStatus=(int) Math.floor(Math.random() * 10) % 2; //Get attendance as 0 or 1 for absent and present respectively
		if (attendanceStatus == IS_FULL_TIME)				           //Condition check for 0 or 1
			System.out.println("Employee is present");
		else
			System.out.println("Employee is absent");
	}

}

