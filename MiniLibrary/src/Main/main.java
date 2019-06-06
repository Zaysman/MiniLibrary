package Main;
//Libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.time.LocalDate;


//Objects
import objects.book;
import objects.user;



public class main {
	//Global Variables
	static int highestBookID; //Holds the highest used bookID
	static int highestUserID; //Holds the highest used UserID
	static book[] books = new book[20]; //This array will hold all of the books in library. Initially limited to 20 
	static user[] users = new user[10]; //This array will hold all of the users that may access the library. Initially limited to 10 users
	static char charInput; //Stores character input for use in menus
	static Scanner input = new Scanner(System.in); //This scanner is used for user input

	
	//Files
	static File user = new File("UserInfo");
	static File library = new File("MyLibrary");
	


	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//variables
		Scanner UserInfo = new Scanner(user); //Scanner for UserInfo.txt
		Scanner MyLibrary = new Scanner(library); //Scanner for MyLibrary.txt
		String line = new String(); //Strings that holds the text from each text file
		String field = new String(); //Strings that will hold each field for users and books
		StringTokenizer tokenizer; //Splits strings into tokens separated by commas
		int fileIterator = 0; //iterator that goes through books and users arrays
		int token = 1; //int value that tracks the current token being used, range: 1-6.
		
		for(int i = 0; i<books.length; i++) { //initialize books array
			books[i] = new book();
		}
		
		for(int i = 0; i<users.length; i++) { //initalize users array
			users[i] = new user();
		}
		
		//Test Strings
		System.out.println("Sample Line to be written to file:");
		book b1 = new book();
		b1.setID(15);
		b1.setTitle("Awesome Adventures!");
		b1.setAuthor("Captain Awesome");
		b1.setStatus("Library");
		b1.setCheckOutDate();
		/*
		System.out.println(b1.toString());
		System.out.println();
		*/
		
		System.out.println("Sample User to be written to file");
		user u1 = new user();
		u1.setID(9);
		u1.setFirstName("Alexander");
		u1.setLastName("Strider");
		u1.setAcctName("Acct4");
		u1.setPassword("123as124");
		u1.setType('B');
		/*
		System.out.println(u1.toString());
		System.out.println();
		*/
		//Populate user & book arrays
		
		//UserInfo
		while(UserInfo.hasNext()) {
			line = UserInfo.nextLine(); //Goes line by line to collect information
			tokenizer = new StringTokenizer(line, ",");
			//System.out.println(line); //Prints out line to make sure everything is collected. Will remove later
			
			//Splits line String into individual strings and assigns values to each field of user object within user array
			while(tokenizer.hasMoreTokens()) { //converts line into tokens
				field = tokenizer.nextToken();
				//System.out.print(field + " - ");
				if(token == 1) { //First token is the user id
					//System.out.print("User id");
					users[fileIterator].setID(Integer.parseInt(field));
					token++;
				}
				else if(token == 2) { //Second token is first name
					//System.out.print("First Name");
					users[fileIterator].setFirstName(field);
					token++;
				}
				else if(token == 3) { //Third token is last name
					//System.out.print("Last Name");
					users[fileIterator].setLastName(field);
					token++;
				}
				else if(token == 4) { //fourth token is account name
					//System.out.print("Account Name");
					users[fileIterator].setAcctName(field);
					token++;
				}
				else if(token == 5) { //fifth token is the user password
					//System.out.print("Password");
					users[fileIterator].setPassword(field);
					token++;
				}
				else if(token == 6) { //Sixth and final token is user type. token is set back to 1.
					//System.out.print("Type");
					users[fileIterator].setType(field.charAt(0));
					token = 1;
				}
				//System.out.println();
			} //end of inner while loop
			fileIterator++;
			/*
			System.out.println();
			System.out.println();
			*/
		} //end of outer while loop
		
		
		field = new String();
		line = new String();
		token = 1;
		fileIterator = 0;
		
		while(MyLibrary.hasNext()) {
			line = MyLibrary.nextLine();
			tokenizer = new StringTokenizer(line, ",");
			//System.out.println(line);
			while(tokenizer.hasMoreTokens()) {
				field = tokenizer.nextToken();
				//System.out.print(field + " - ");
				if(token == 1) { //First field of books is user id
					//System.out.print("Book id");
					books[fileIterator].setID(Integer.parseInt(field));
					token++;
				}
				else if(token == 2) { //Second field of books is title
					//System.out.print("Title");
					books[fileIterator].setTitle(field);
					token++;
				}
				else if(token == 3) { //Third field of books is author
					//System.out.print("Author");
					books[fileIterator].setAuthor(field);
					token++;
				}
				else if(token == 4) { //Fourth field of books is status
					//System.out.print("Status");
					books[fileIterator].setStatus(field);
					token++;
				}
				else if(token == 5) { //Fifth field of books is checkout date
					//System.out.print("Checkout Date");
					books[fileIterator].setCheckOutDate(field);
					token++;
				}
				else if(token == 6) { //Sixth and final field of books is due date
					//System.out.print("Due Date");
					books[fileIterator].setDueDate(field);
					token = 1;
				}
				//System.out.println();
				
			}//end of inner while loop
			fileIterator++;
			/*
			System.out.println();
			System.out.println();
			*/
		}//end of outer while loop
		/*
		System.out.println();
		System.out.println();
		*/
		//print out users array to check
		for(int i = 0; i<users.length; i++) { //prints out users array to check if everything was added correctly
			if(users[i].getID() == 0) { //User id's start at 1. If a user with an id of 0 is found, then we've run out of users.
				break;
			}
			System.out.print("id: " + users[i].getID() + ",");
			System.out.print("First Name: " + users[i].getFirstName() + ",");
			System.out.print("Last Name: " + users[i].getLastName() + ",");
			System.out.print("Account Name: " + users[i].getAcctName() + ",");
			System.out.print("Password: " + users[i].getPassword() + ",");
			System.out.print("Type: " + users[i].getType());
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//print out books array to check 
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) { //Book id's start at 1. If a book with an id of 0 is found, we've run out of books.
				break;
			}
			System.out.print("id: " + books[i].getID() + ",");
			System.out.print("Title: " + books[i].getTitle() + ",");
			System.out.print("Author: " + books[i].getAuthor() + ",");
			System.out.print("Status: " + books[i].getStatus() + ",");
			System.out.print("Checkout Date: " + books[i].getCheckOutDate() + ",");
			System.out.print("Due Date: " + books[i].getDueDate());
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//finding highest user id
		highestUserID = users[0].getID(); 
		for(int i = 1; i<users.length; i++) { //Looks through books array for book id's
			if(users[i].getID() == 0) { //If an id of 0 is found, we stop looking through the array
				break;
			}
			if(users[i].getID() > highestUserID) { //if an id is higher than the first id in the array, that id is set as the highest id
				highestUserID = users[i].getID();
			}
		}
		System.out.println("Highest User ID: " + highestUserID);
		
		//finding highest book id
		highestBookID = books[0].getID();
		for(int i = 1; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			if(books[i].getID() > highestBookID) {
				highestBookID = books[i].getID();
			}
		}
		System.out.println("Highest Book ID: " + highestBookID);
		
		
		//menu prompt
		System.out.println("Hello! Welcome to the minilibrary");
		System.out.println(" ");

		System.out.print("Are you a Borrower(B) or Librarian(L): ");
		mainMenu();


	}

	public static void mainMenu() throws IOException {
		char charInput = ' ';
		charInput = input.next().charAt(0);

		switch(charInput) {
		case 'B':
			System.out.println("Welcome Borrower");
			System.out.println();
			borrowerMenu();
			break;

		case 'L':
			System.out.println("Welcome Librarian");
			System.out.println();
			librarianMenu();
			break;

		default:
			System.out.println("That character is invalid. Are you a Borrower(B) or Librarian(L)");
			mainMenu();
			break;
		}

	}



	public static void borrowerMenu() {
		charInput = ' ';	
		System.out.println("Borrower Menu"); 
		System.out.println();

		System.out.println("Enter 'q' for book query by author");
		System.out.println("Enter 's' for book status by book title");
		System.out.println("Enter 'u' to print all books checked out by user");
		System.out.println("Enter 'x' to exit the library");

		charInput = input.next().charAt(0);

		switch(charInput) {
		case 'q':
			System.out.println();
			bookQuery();
			break;

		case 's':
			System.out.println();
			bookStatus();
			break;

		case 'u':
			System.out.println();
			listBooks();
			break;
		case 'x':
			System.out.println("Thank you for using the library");
			return;

		default:
			System.out.println("The character you entered is invalid. Please input a character from the menu");
			System.out.println();
			borrowerMenu();
			break;
		}
	}


	//Borrower Methods	

	public static void bookQuery() {
		charInput = ' ';
		// TODO Auto-generated method stub
		//variables
		String author = new String(); //String that holds the user's input
		int matches = 0; //Int variable that tracks the number of matches found
		book[] match = new book[20]; //Array that holds the books that have been matched
		int matchIndex = 0; //Int variable that iterates through match array
		boolean menu = true;
		
		System.out.print("Name of the Author you want to query: ");
		author = input.next();
		System.out.println();
		
		System.out.println("The Author you entered: " + author);
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getAuthor() == null) { //if we find a null value for author, then we've run out of books to check
				break;
			}
			if(books[i].getAuthor().compareTo(author) == 0) {
				matches++;
				match[matchIndex] = books[i];
				matchIndex++;
			}	
		}
		
		if(matches == 0) { //If there were no matches
			System.out.println("Sorry, there were no matches found for your query");
			
			while(menu == true) {
			System.out.println("Would you like to try again(t) or return to the menu(b)");
			charInput = input.next().charAt(0);
			
			switch(charInput) {
				case 't':
					bookQuery();
					menu = false;
					break;
				case 'b':
					return;
				
				default:
					System.out.println("The character you entered is invalid You need to enter a valid character");
				}
			}
		} else {
			
			System.out.println("There were " + matches + " matches");
			
			System.out.println("Matches:");
			for(int i = 0; i<match.length; i++) {
				if(match[i] == null) {
					break;
				} 
				System.out.println(match[i].toString());
			}
			
		}
		System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
		
		while(menu = true) {
			charInput = input.next().charAt(0);
			switch(charInput) {
				case 't':
					menu = false;
					bookQuery();
					break;
				
				case 'b':
					menu = false;
					borrowerMenu();
					break;
					
				default :	
					System.out.println("The character you entered is invalid You need to enter a valid character");
					System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
					charInput = ' ';
					break;
			}
		}
	}


	public static void bookStatus() {
		// TODO Auto-generated method stub
		charInput = ' ';
		String title = new String();
		int matches = 0;
		book[] match = new book[20];
		int matchIndex = 0;
		boolean menu = true;
		
		System.out.print("What is the title of the book you wish to Query: ");
		title = input.next();
		System.out.println();
		System.out.println("The title you entered: " + title);
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getTitle() == null) { //If a book without a title is found, we've run out of usable books
				break;
			}
			if(books[i].getTitle().compareTo(title) == 0) {
				matches++;
				match[matchIndex] = books[i];
				matchIndex++;
			}
		}
	
		if(matches == 0) {
			System.out.println("There is no such book");
			System.out.println();
			System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
			while(menu == true) {
				charInput = input.next().charAt(0);
				
				switch(charInput) {
				case 't':
					menu = false;
					bookStatus();
					break;
					
				case 'b':
					menu = false;
					borrowerMenu();
					break;
					
				default:
					System.out.println("The character you entered is invalid. Please choose a valid character from the menu");
					System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
					charInput = ' ';
					break;
				}
				
			}
			
		}// end of if statement
		else {
			System.out.println("There were " + matches + " matches");
			
			System.out.println("Matches:");
			
			for(int i = 0; i<match.length; i++) {
				if(match[i] == null) {
					break;
				}
				if(match[i].getStatus().compareTo("Library") == 0) {
					System.out.println(title + " is available in Library.");
				} else {
					System.out.println(title + " is available after " + match[i].getDueDate().toString());
				}	
			}
			
			System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
			
			while(menu = true) {
				charInput = input.next().charAt(0);
				switch(charInput) {
					case 't':
						menu = false;
						bookStatus();
						break;
					
					case 'b':
						menu = false;
						borrowerMenu();
						break;
						
					default :	
						System.out.println("The character you entered is invalid You need to enter a valid character");
						System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
						charInput = ' ';
						break;
				}
			}
		}
	}


	public static void listBooks() {
		// TODO Auto-generated method stub
		charInput = ' ';
		String user = new String();
		int matches = 0;
		book[] match = new book[20];
		int matchIndex = 0;
		boolean menu = true;
		
		System.out.println("What is the Account name of the user you want to list books for: ");
		user = input.next();
		System.out.println("Account name that you entered: " + user);
		
		System.out.println();
		System.out.println();

		for(int i = 0; i<books.length; i++) {
			if(books[i] == null) {
				break;
			}
			if(books[i].getStatus().compareTo(user) == 0) {
				matches++;
				match[matchIndex] = books[i];
				matchIndex++;
			}
		}
		
		if(matches == 0) {
			System.out.println("The Account Name you entered has no books checked out currently");
			System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
			
			while(menu == true) {
				charInput = input.next().charAt(0);
				switch(charInput) {
					case 't':
						menu = false;
						bookStatus();
						break;
					
					case 'b':
						menu = false;
						listBooks();
						break;
						
					default :	
						System.out.println("The character you entered is invalid You need to enter a valid character");
						System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
						charInput = ' ';
						break;
				}
				
				
			}
			
			
		}
		System.out.println("There were " + matches + " matches");
		System.out.println("Matches:");
		
		for(int i = 0; i<match.length; i++) {
			if(match[i] == null) {
				break;
			}
			System.out.println(match[i].toString());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
		
		while(menu == true) {
			charInput = input.next().charAt(0);
			switch(charInput) {
				case 't':
					menu = false;
					listBooks();
					break;
				
				case 'b':
					menu = false;
					borrowerMenu();
					break;
					
				default :	
					System.out.println("The character you entered is invalid You need to enter a valid character");
					System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
					charInput = ' ';
					break;
			}
			
			
		}
		
		
		

	}


	//Librarian Methods

	public static void librarianMenu() throws IOException {
		charInput = ' ';
		System.out.println("Librarian Menu");
		System.out.println();

		System.out.println("Press 'a' to add a book to the library");
		System.out.println("Press 'd' to delete a book from the library");
		System.out.println("Press 'o' to check out a book from the library");
		System.out.println("Press 'r' to return a book to the library");
		System.out.println("Press 'x' to exit the menu");

		charInput = input.next().charAt(0);

		switch(charInput) {
			case 'a':
				System.out.println();
				addBook();
				break;
			case 'd':
				System.out.println();
				deleteBook();
				break;
			case 'o':
				System.out.println();
				checkOutBook();
				break;
			case 'r':
				System.out.println();
				returnBook();
				break;
			case 'x':
				System.out.println("Thank you for using the library.");
				return;
				
			default:
				System.out.println("The character you entered is invalid. Please enter a character from the menu");
				System.out.println();
				librarianMenu();
				break;
		}

	}



	public static void addBook() throws IOException {
		// TODO Auto-generated method stub
		//variables
		charInput = ' ';
		book newBook = new book();
		boolean menu = true;
		FileWriter libraryWriter;
		String field = new String();
		field = input.nextLine();
		String text = new String();
		
		newBook.setID(highestBookID + 1);
		highestBookID++;
		
		
		System.out.print("Title of new Book: ");
		field = input.nextLine();
		newBook.setTitle(field);
		
		System.out.println();
		field = new String();
		
		System.out.print("Author of new Book: ");
		field = input.nextLine();
		newBook.setAuthor(field);
		System.out.println();
		
		System.out.println("Book to be added: " + newBook.toString());
		
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) { //When we encounter our first null book, that is where we add the new book in the array
				books[i] = newBook;
				break;
			}
		}
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			text += books[i].toString();
			text += "\n";
		}
		
		/*
		System.out.println("text:");
		System.out.println(text);
		*/
		
		libraryWriter = new FileWriter(library, false); //Filewriter constructor w/ to parameter. false means this FileWriter will overwrite the existing file.
		libraryWriter.write(text);
		libraryWriter.close();
		
		System.out.println("**Book has been successfully added to library!**");
		
		System.out.println("Do you want to try again(t) or return to the borrower menu(b)?");
		
		while(menu == true) {
			charInput = input.next().charAt(0);
			switch(charInput) {
				case 't':
					menu = false;
					addBook();
					break;
				
				case 'b':
					menu = false;
					librarianMenu();
					break;
					
				default :	
					System.out.println("The character you entered is invalid You need to enter a valid character");
					System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
					charInput = ' ';
					break;
			}	
		}
	}


	public static void deleteBook() throws IOException {
		// TODO Auto-generated method stub
		charInput = ' ';
		boolean menu = true;
		FileWriter libraryWriter;
		String deleteTitle = new String();
		deleteTitle = input.nextLine();
		String text = new String();
		int deleteIndex = -1; //Holds the index where the book to be deleted was found within the array
		
		System.out.print("Title of the Book you want to delete: ");
		deleteTitle = input.nextLine();
		
		System.out.println();
		System.out.println("Title entered: " + deleteTitle);
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			if(deleteTitle.compareTo(books[i].getTitle()) == 0) {
				deleteIndex = i;
				break;
			}	
		}
		if(deleteIndex == -1) {
			System.out.println("The Book you searched for could not be found.");
			System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
			while(menu == true) {
				charInput = input.next().charAt(0);
				switch(charInput) {
					case 't':
						menu = false;
						deleteBook();
						break;
					
					case 'b':
						menu = false;
						librarianMenu();
						break;
						
					default :	
						System.out.println("The character you entered is invalid You need to enter a valid character");
						System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
						charInput = ' ';
						break;
				}
			}
		}
		
		System.out.println("The book to be deleted was found at index: " + deleteIndex);
		
		for(int i = deleteIndex; i<books.length - 1; i++) {
			books[i] = books[i+1];
		}
		
		/*
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) { //Book id's start at 1. If a book with an id of 0 is found, we've run out of books.
				break;
			}
			System.out.print("id: " + books[i].getID() + ",");
			System.out.print("Title: " + books[i].getTitle() + ",");
			System.out.print("Author: " + books[i].getAuthor() + ",");
			System.out.print("Status: " + books[i].getStatus() + ",");
			System.out.print("Checkout Date: " + books[i].getCheckOutDate() + ",");
			System.out.print("Due Date: " + books[i].getDueDate());
			System.out.println();
		}
		*/
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			text += books[i].toString();
			text += "\n";
		}
		
		libraryWriter = new FileWriter(library, false); //Filewriter constructor w/ to parameter. false means this FileWriter will overwrite the existing file.
		libraryWriter.write(text);
		libraryWriter.close();
		
		System.out.println("**Book Deleted Successfully.**");
		
	}


	public static void checkOutBook() throws IOException {
		// TODO Auto-generated method stub
		charInput = ' ';
		boolean menu = true;
		boolean bookFound = false;
		FileWriter libraryWriter;
		int checkouts = 0;
		String acctName = new String();
		String bookTitle = new String();
		String text = new String();
		
		
		System.out.print("Account Name of user to check out book: ");
		acctName = input.next();
		
		System.out.println();
		System.out.println("Account Name Entered: " + acctName);
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			if(books[i].getStatus().compareTo(acctName) == 0) {
				checkouts++;
			}
			if(checkouts == 3) {
				break;
			}
		}
		
		if(checkouts == 3) {
			System.out.println("Sorry, but " + acctName + " has already checked out 3 books.");
			
			System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
			while(menu == true) {
				charInput = input.next().charAt(0);
				switch(charInput) {
					case 't':
						menu = false;
						checkOutBook();
						break;
					
					case 'b':
						menu = false;
						librarianMenu();
						break;
						
					default :	
						System.out.println("The character you entered is invalid You need to enter a valid character");
						System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
						charInput = ' ';
						break;
				}
			}	
		}
		
		System.out.println(acctName + " has checked out " + checkouts + " books." );
		System.out.println(acctName + " is eligible to checkout another book.");
		
		System.out.print("Title of the book to be checked out: ");
		bookTitle = input.next();
		System.out.println();
		
		System.out.println("Book Title Entered: " + bookTitle);
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}			
			if(books[i].getTitle().compareTo(bookTitle) == 0) {
				if(books[i].getStatus().compareTo("Library") != 0) {
					System.out.println("Sorry, but " + books[i].getStatus() + " has already checked this book out.");
					System.out.println("The book is due on: " + books[i].getDueDate().toString());
					break;
				}
				bookFound = true;
				System.out.println("**Book Found**"); //Prints out that the book has been found
				books[i].setStatus(acctName); //Sets status to the account name.
				books[i].setCheckOutDate();
				break;
			}
		}
		
		if(bookFound == false) {
			System.out.println("Sorry, but the book you searched for was not found");
			System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
			while(menu == true) {
				charInput = input.next().charAt(0);
				switch(charInput) {
					case 't':
						menu = false;
						checkOutBook();
						break;
					
					case 'b':
						menu = false;
						librarianMenu();
						break;
						
					default :	
						System.out.println("The character you entered is invalid You need to enter a valid character");
						System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
						charInput = ' ';
						break;
				}
			}		
		}
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			text += books[i].toString();
			text += "\n";
		}
		
		libraryWriter = new FileWriter(library, false); //Filewriter constructor w/ to parameter. false means this FileWriter will overwrite the existing file.
		libraryWriter.write(text);
		libraryWriter.close();
		
		System.out.println("**Book Checked Out successfully Successfully.**");
		
		System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
		while(menu == true) {
			charInput = input.next().charAt(0);
			switch(charInput) {
				case 't':
					menu = false;
					checkOutBook();
					break;
				
				case 'b':
					menu = false;
					librarianMenu();
					break;
					
				default :	
					System.out.println("The character you entered is invalid You need to enter a valid character");
					System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
					charInput = ' ';
					break;
			}
		}
	}


	public static void returnBook() throws IOException {
		// TODO Auto-generated method stub
		charInput = ' ';
		boolean bookFound = false;
		boolean menu = true;
		FileWriter libraryWriter;
		String returnTitle = new String();
		returnTitle = input.nextLine();
		String text = new String();
		
		System.out.print("Title of the book being returned: ");
		returnTitle = input.nextLine();
		
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			if(books[i].getTitle().compareTo(returnTitle) == 0) {
				bookFound = true;
				if(books[i].getStatus().compareTo("Library") == 0) {
					System.out.println("The book is already within the library");
					break;
				}
				books[i].setStatus("Library");
				books[i].setCheckOutDate("null");
				books[i].setDueDate("null");
				break;
			}
		}
		
		if(bookFound = false) {
			System.out.println("Sorry, but " + returnTitle + " wasn't found");
			
			System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
			while(menu == true) {
				charInput = input.next().charAt(0);
				switch(charInput) {
					case 't':
						menu = false;
						returnBook();
						break;
					
					case 'b':
						menu = false;
						librarianMenu();
						break;
						
					default :	
						System.out.println("The character you entered is invalid You need to enter a valid character");
						System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
						charInput = ' ';
						break;
				}
			}
		}
		
		for(int i = 0; i<books.length; i++) {
			if(books[i].getID() == 0) {
				break;
			}
			text += books[i].toString();
			text += "\n";
		}
		
		libraryWriter = new FileWriter(library, false); //Filewriter constructor w/ to parameter. false means this FileWriter will overwrite the existing file.
		libraryWriter.write(text);
		libraryWriter.close();
		
		System.out.println("**Book Successfully Returned**");
		
		System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
		while(menu == true) {
			charInput = input.next().charAt(0);
			switch(charInput) {
				case 't':
					menu = false;
					checkOutBook();
					break;
				
				case 'b':
					menu = false;
					librarianMenu();
					break;
					
				default :	
					System.out.println("The character you entered is invalid You need to enter a valid character");
					System.out.println("Do you want to try again(t) or return to the librarian menu(b)?");
					charInput = ' ';
					break;
			}
		}
	}
}
