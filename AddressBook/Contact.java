public class Contact {
	/* ********* INSTANCE VARIABLES ******* */
    private String firstname; 
    private String lastname;
    private String address;  
    private long phonenumber; 
    private long zip;

    /* CONSTRUCTOR: Creates Contact object based on parameters.*/
   
    public Contact(String n,String l, String a, long z,long p) {
		firstname = n;
		lastname=l;
		address = a;
		zip=z;
		phonenumber = p;	
    }
    
    /* *********** INSTANCE METHODS ******* */
   
    /* Changes phone number of contact */
    public void changeNumber(long newnum) {
		phonenumber = newnum;
		System.out.println("Edit successful.Updated contact details: ");
    }
    
    /* Changes zip code of contact */
    public void changeZip(long newzip) {
		zip = newzip;
		System.out.println("Edit successful.Updated contact details: ");
    }
    
    /* Changes address of contact */
    public void changeAddress(String newaddress) {
		address = newaddress ;
		System.out.println("Edit successful.Updated contact details: ");
	}

    /* Returns the name of a Contact */
    public String getFirstName() {
		return firstname;
    }
    public String getLastName() {
		return lastname;
    }

    /* Returns the address of a Contact*/
    public String getAddress() {
		return address;
    }

    /* Returns the phone number of a Contact */
    public long getNumber() {
		return phonenumber;
    }
    
    /* Returns the zip code of a Contact*/
    public long getZip() {
    	return zip;
    }

    /* Prints all information about a contact out. */
    public void printContact() {
		System.out.println("Name: " + firstname + " "+lastname+" Address: " + address + " Zip: "+ zip +" Phone number: " + phonenumber);
		
    }

   

}
