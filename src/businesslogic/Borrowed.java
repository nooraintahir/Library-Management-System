package businesslogic;

public class Borrowed {
	private int User_id;
	private int Book_id;
	

	public Borrowed(int Uid, int Bid) {
	
		this.User_id = Uid;
		this.Book_id = Bid;
		
		
	}
	
	public int getUserid() {
		return User_id;
	}
	public void setUserid(int id) {
		this.User_id = id;
	}
	
	public int getBookid() {
		return Book_id;
	}
	public void setBookid(int id) {
		this.Book_id = id;
	}
	
	
	@Override
	public String toString() {
		return "Borrowed [Userid=" + User_id + ", Bookid = "+ Book_id+"  ]";
	}
	
}
