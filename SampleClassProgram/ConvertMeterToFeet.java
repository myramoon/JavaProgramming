//Sample class program demonstrating various parts of a class.

import java.util.Scanner;

public class ConvertMeterToFeet {

	//CONSTANTS
	static final double INDEX=3.280;  		//fixed for every instance of the class

	//INSTANCE VARIABLES
	public double meter;			
	public double feet;

	//CONSTRUCTOR
	public ConvertMeterToFeet(double m) {
       		this.meter=m;
	}

	//INSTANCE METHOD
	public void calculatefeet() {
		this.feet=this.meter * INDEX;	//converts measure in meters into feet
	}
	public void display() {
        	System.out.println("Measure in feet is : "+this.feet); //Print feet measure
	}

	//MAIN MODULE
	public static void main (String[] args) {
		Scanner scan=new Scanner(System.in);			//create instance of scanner class to take user input
		System.out.println("Enter measure in meters : ");	
		double m=scan.nextDouble();				//scan user input
		ConvertMeterToFeet c1=new ConvertMeterToFeet(m);	//call to constructor
        	c1.calculatefeet();					//call to method doing conversion
        	c1.display();     					//call to method that displays output
        	scan.close();						//close scanner object 	
        }
		

}



