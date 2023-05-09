package businesslogic;

public class Book {
	private String title;
	private String Author;
	private boolean borrowed;
	private int Book_id;
	

	public Book(String title, String A, boolean bor, int Bid) {
	
		this.title = title;
		this.Author = A;
		this.borrowed = bor;
		this.Book_id = Bid;
	
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String A) {
		this.Author = A;
	}
	
	public boolean getborrowed() {
		return borrowed;
	}
	public void setborrowed(boolean bor) {
		this.borrowed =  bor;
	}
   	
	public int getBookid() {
		return Book_id;
	}
	public void setBookid(int id) {
		this.Book_id = id;
	}
	
	
	@Override
	public String toString() {
		return "Book [Title=" + title + ", Author = "+ Author+" , borrowed = "+ borrowed+", Book_id = "+Book_id+"  ]";
	}
	
}
