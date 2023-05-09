package database;


import java.util.ArrayList;

import businesslogic.Borrower;
import businesslogic.Book;
import businesslogic.Borrowed;
import businesslogic.Librarian;



public abstract class persistenthandler {

	persistenthandler(){
		
	}
	
	public abstract ArrayList<Borrower> readborrower();
	public abstract void saveborrower(Borrower b); 
	public abstract boolean updateborrower(int bid, String name, String email, int phone, boolean lib_card);
	public abstract boolean deleteborrower(int bid); 
	
	public abstract ArrayList<Book> readbook();
	public abstract void savebook(Book b);
	public abstract boolean updatebook(int Book_id, String title, String author, boolean borrowed);
	public abstract boolean deletebook(int bookid);
	
	public abstract ArrayList<Librarian> readlib();
	public abstract void savelib(Librarian l);
	public abstract boolean updatelib(int id, String name, String pass);
	
	public abstract ArrayList<Borrowed> readborr();
	public abstract void saveborr(Borrowed b);
	public abstract boolean updateborrowed(int bookid, int userid);
	public abstract boolean deleteborr(int userid);
	
	public abstract ArrayList<Book> searchbook(String keyword);
	
}
