package objects;

import java.util.Date;
import java.time.LocalDate;

public class book {
	//Fields
	private int id; //the book's id number
	private String title;
	private String author;
	private String status;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	//private LocalDate test;
	//Constructors
	
	/**
	 * Default Constructor
	 * When a book is created, we assume it goes straight to the library. It's status is automatically set to library and it's dates are set to null.
	 */
	public book() {
		this.id = 0;
		this.title = new String();
		this.author = new String();
		this.status = "Library";
		this.checkOutDate = null;
		this.dueDate = null;	
	}
	
	/**
	 * Constructor with integer parameter. The book's id is set to the passed integer. All other values are initialized.
	 * @param id, the value that the new book's id value will be set to
	 */
	public book(int id) {
		this.id = id;
		this.title = new String();
		this.author = new String();
		this.status = "Library";
		this.checkOutDate = null;
		this.dueDate = null;	
	}
	
	/**
	 * String Constructor, Based on the value of the field parameter, one of the string values is initialized with the passed strings. All other values are initialized
	 * 
	 * @param field, integer that determines which strings in going to initialized
	 * @param str, the string object that holds the string the field in questiong is going to be changed to.
	 */
	public book(int field, String str) {
		this.id = 0;
		
		if(field == 1) {
			this.title = str;
		} else {
			this.title = new String();
		}
		if(field == 2) {
			this.author = str;
		} else {
			this.author = new String();
		}
		if(field == 3) {
			this.status = str;
		} else {
			this.status = new String();
		}
		this.checkOutDate = null;
		this.dueDate = null;
	}
	
	//Accessor Methods
	public int getID() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public LocalDate getCheckOutDate() {
		return this.checkOutDate;
	}
	
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
	//Modifier Methods
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCheckOutDate() {
		this.checkOutDate = LocalDate.now();
		this.dueDate = LocalDate.now().plusDays(30);
	}
	
	public void setCheckOutDate(String date) {
		if(date.compareTo("null") == 0) {
			this.checkOutDate = null;
		} else {
			this.checkOutDate = LocalDate.parse(date);
		}
	}
	
	public void setDueDate(String date) {
		if(date.compareTo("null") == 0) {
			this.dueDate = null;
		} else {
			this.dueDate = LocalDate.parse(date);
		}
	}
	
	public String toString() {
		String str = this.id + "," + this.title + "," + this.author + "," + this.status + ",";
		if(this.checkOutDate == null || this.dueDate == null) {
			str = str.concat("null,null");
		} else {
			str = str.concat(this.checkOutDate.toString() + "," + this.dueDate.toString());
		}
		return str;
	}
	
}

