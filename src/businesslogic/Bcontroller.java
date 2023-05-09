package businesslogic;

import java.util.ArrayList;

import database.dbhandler;
import database.persistenthandler;


public class Bcontroller {
	private persistenthandler ph;
	
	public Bcontroller(){
		ph=new dbhandler();
		}
	
	public ArrayList<Borrower> readborrower()
	{
		return ph.readborrower();
	}
	public void saveborrower(int bid, int phone, String name, String email, String pass, boolean lib_card)
	{
		Borrower b = new Borrower(bid,phone, name, email,pass,lib_card);
		ph.saveborrower(b);
	}
	public boolean updateborrower(int bid, String name, String email, int phone, boolean lib_card)
	{
		return ph.updateborrower(bid, name, email, phone, lib_card);
	}
	public boolean deleteborrower(int bid)
	{
		return ph.deleteborrower(bid);
	}
	
	public ArrayList<Book> readbook()
	{
		return ph.readbook();
	}
	public void savebook(String title, String A, boolean bor, int Bid)
	{
		Book b =  new Book(title,A,bor,Bid);
		ph.savebook(b);
	}
	public boolean updatebook(int Book_id, String title, String author, boolean borrowed)
	{
		return ph.updatebook(Book_id, title, author, borrowed);
	}
	public boolean deletebook(int bookid)
	{
		return ph.deletebook(bookid);
	}
	public ArrayList<Librarian> readlib()
	{
		return ph.readlib();
	}
	public void savelib(int id,  String name, String pass)
	{
		Librarian l = new Librarian(id,name,pass);
		ph.savelib(l);
	}
	public boolean updatelib(int id, String name, String pass)
	{
		return ph.updatelib(id, name, pass);
	}
	
	public ArrayList<Borrowed> readborr()
	{
		return ph.readborr();
	}
	public void saveborr(int Uid, int Bid)
	{
		Borrowed b = new Borrowed(Uid,Bid);
		ph.saveborr(b);
	}
	public boolean updateborrowed(int bookid, int userid)
	{
		return ph.updateborrowed(bookid, userid);
	}
	public boolean deleteborr(int userid)
	{
		return ph.deleteborr(userid);
	}
	
	public ArrayList<Book> searchbook(String keyword)
	{
		return ph.searchbook(keyword);
	}
}
