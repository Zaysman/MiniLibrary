package objects;

public class user {
	//Fields
	
	private int id; //User id
	private String firstName; //User's first name
	private String lastName; //User's last name
	private String acctName; //User's account name
	private String password; //User's password
	private char type; //Type of user. B-Borrower L-Librarian
	
	
	//Constructors
	
	/**
	 * Default Constructor
	 */
	public user() {
		this.id = 0;
		this.firstName = new String();
		this.lastName = new String();
		this.acctName = new String();
		this.password = new String();
		this.type = ' ';
	}
	
	/**
	 * Integer Constructor. The User's id is set to the integer passed to the constructor
	 * @param id, integer value that the user's id is set to.
	 */
	public user(int id) {
		this.id = id;
		this.firstName = new String();
		this.lastName = new String();
		this.acctName = new String();
		this.password = new String();
		this.type = ' ';
	}
	
	/**
	 * String Constructor.
	 * @param field, integer value that determines which String field is going to be set.
	 * @param str, the string that the chosen field will be set to.
	 */
	public user(int field, String str) {
		this.id = 0;
		if(field == 1) {
			this.firstName = str;
		} else {
			this.firstName = new String();
		}
		if(field == 2) {
			this.lastName = str;
		} else {
			this.lastName = new String();
		}
		if(field == 3) {
			this.acctName = str;
		} else {
			this.acctName = new String();
		}
		if(field == 4) {
			this.password = str;
		} else {
			this.password = new String();
		}
		this.type = ' ';
	}
	
	/**
	 * Character Constructor. Sets type to the passed character
	 * @param type, character value that type will be changed to
	 */
	public user(char type) {
		this.id = 0;
		this.firstName = new String();
		this.lastName = new String();
		this.acctName = new String();
		this.password = new String();
		this.type = type;
	}
	
	//Accessor Methods
	
	public int getID() {
		return this.id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getAcctName() {
		return this.acctName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public char getType() {
		return this.type;
	}
	
	//Modifier Methods
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setFirstName(String str) {
		this.firstName = str;
	}
	
	public void setLastName(String str) {
		this.lastName = str;
	}
	
	public void setAcctName(String str) {
		this.acctName = str;
	}
	
	public void setPassword(String str) {
		this.password = str;
	}
	
	public void setType(char ch) {
		this.type = ch;
	}
	
	public String toString() {
		String str = this.id + "," + this.firstName + "," + this.lastName + "," + this.acctName + "," + this.password + "," + this.type;
		return str;
		
	}
	
}