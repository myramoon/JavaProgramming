import java.io.*;
import java.util.Scanner;

public class AddressBook {
	
    private Contact[] friends; // An array of Contacts - each stores information for one friend
    private int numfriends;   

    /* CONSTRUCTOR: Creates empty AddressBook */
    public AddressBook() {    
    	
		friends = new Contact[10];	
		numfriends = 0;
    }

    /* *********** INSTANCE METHODS *********** */
   
    /* Adds a contact that's passed in as a parameter. */
    public void addContact(Contact c) {   
		friends[numfriends] = c;		
		numfriends++;
    }
    

    /* Prints information of all contacts */
    public void printContacts() {  
		for (int i=0;i<numfriends;i++)
	    	friends[i].printContact();
    }

    /* Returns the number of friends currently in AddressBook  */
    public int numContacts() { 
		return numfriends;
    }

    /* Returns a non-negative integer if a Contact with name s exists corresponding to which place in the array friends the Contact is stored.Returns -1 otherwise.*/
    private int haveContact(String s) {
		for (int i=0;i<numfriends;i++)
	    	if (friends[i].getFirstName().equals(s))
				return i;
	    	else System.out.println("Sorry!You dont have this contact.");
			    return -1;
    }
    
    /* Creates new contact */
    public void createContact(AddressBook blackbook)throws IOException {
    	
    	Scanner stdin = new Scanner(System.in);
		
		if (blackbook.numContacts() < 10) {
    		/* Reads in all appropriate information */
			
			System.out.println("Enter first name:");
    		String firstname = stdin.next();
    		
    		/* Validation code */
    		int check = blackbook.haveContact(firstname);
    		if(check >= 0) {
    			System.out.println("You already have this contact.");
    	        return;
    		}
    		
    		System.out.println("Enter last name:");
    		String lastname = stdin.next();
    		
    		System.out.println("Enter address.");
    		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    		String address = reader.readLine(); 	
    		
    		System.out.println("Enter zip code: ");
    		long zip = stdin.nextLong();
    		
    		System.out.println("Enter their phone number.");
    		long number = stdin.nextLong();
    		
    		/* Uses above information to create Contact object, which is passed in parameters to the addContact method.*/
    		blackbook.addContact(new Contact(firstname,lastname,address,zip,number));
    		System.out.println("Contact created.");
        }
		
		else {
    		System.out.println("Sorry, can not add anyone, memory is full.");
		}
		
    }
    
    /* Edits contact */
    public void editContact(String firstname)throws IOException {
    	
    	int place = haveContact(firstname);
    	if (place >= 0) {
    		System.out.println("Enter 1 to edit address");
    		System.out.println("Enter 2 to edit zip");
    		System.out.println("Enter 3 to edit number : ");
    		Scanner scan = new Scanner(System.in);
    		int choice=scan.nextInt();
    		
    		switch(choice) {
    			case 1:
    				System.out.println("Enter new address.");
    				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    				String newaddress = reader.readLine(); 
    				friends[place].changeAddress(newaddress);
    				friends[place].printContact();
    				break;
    			case 2:
    				System.out.println("Enter new zip: ");
    				long newzip=scan.nextLong();
    				friends[place].changeZip(newzip);
    				friends[place].printContact();
    				break;
    			case 3:
    				System.out.println("Enter new number: ");
    				long newnum=scan.nextLong();
    				friends[place].changeNumber(newnum);
    				friends[place].printContact();
    				break;
    			default:
    				System.out.println("Invalid input");
    		}
    		
    	}
    	
    	else {
    		System.out.println("No such contact exists");
    	}
    	
    }
   
    /* Deletes a contact with firstname, if one is in the AddressBook. */
    public void deleteContact(String firstname) {
	
		int place = haveContact(firstname);
		if (place >= 0) {
	    	friends[place] = friends[numfriends-1];
	    	numfriends--;
	    	System.out.println("Contact deleted.");
		}	
	    else 
	    	System.out.println("No such contact exists");	
		
    }
  /* ***********STATIC METHODS ********* */
    public static void menu() {
		System.out.println("1.Add a new contact to your address book.");
		System.out.println("2.Delete a contact from your address book.");
		System.out.println("3.Edit contact");
		System.out.println("4.Print out information of all of your contacts.");
		System.out.println("5.Quit.");
		System.out.println("Enter your menu choice : ");
    }

    public static void main(String[] args) throws IOException {

		/* Instantiate AddressBook object */
		AddressBook blackbook = new AddressBook();
 		/* Menu driven loop */
		menu();
		Scanner stdin = new Scanner(System.in);
		int choice=stdin.nextInt();
	
		while(choice!=5){
			switch(choice) {
	    
	    		/* Only adds contact if there is room in AddressBook */
				case 1: {
					blackbook.createContact(blackbook);
					break;
	    	    }
	    	
				/* Implements rest of the choices by calling appropriate AddressBook methods on blackbook. */
				case 2: {
					System.out.println("What is the first name of the contact you want to delete?");
					String firstname = stdin.next();
					blackbook.deleteContact(firstname);
					break;
	    	    }
			
				case 3: {
					System.out.println("What is the first name of the contact you want to edit?");
					String firstname = stdin.next();
					blackbook.editContact(firstname);
					break;
				}
				
				case 4: {
					blackbook.printContacts();
					break;
				}
				
				case 5: {
					stdin.close();
					System.exit(0);
				}
			
				default: {
					System.out.println("Sorry, that was an invalid menu choice, try again.");
				}
			}
	    	menu();
	    	choice=stdin.nextInt();
		
	    }
    }	
    
}
