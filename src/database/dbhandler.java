package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businesslogic.Borrower;
import businesslogic.Book;
import businesslogic.Borrowed;
import businesslogic.Librarian;



public class dbhandler extends persistenthandler{
	
	private String usrname = "root";
	private String pass = "nooree2609";
	Connection con; // connection object

	public dbhandler() {
		// connect to DB
		try {
			// university is the database name
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", usrname, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//Borrower
	
	public ArrayList<Borrower> readborrower() {
		ArrayList<Borrower> borr = new ArrayList<Borrower>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM borrower";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Borrower b = new Borrower(rs.getInt(1), rs.getInt(5), rs.getString(2),rs.getString(4),rs.getString(3),rs.getBoolean(6));
				borr.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borr;
	}

	public void saveborrower(Borrower b) {
		try {
			String query="INSERT INTO borrower (bid, name, pass, email, phone, libcard) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, b.getBorrowerid());
			stmt.setInt(5, b.getPhoneNumber());
			stmt.setString(2, b.getName());
			stmt.setString(3, b.getPassword());
			stmt.setString(4, b.getEmail());
			stmt.setBoolean(6, b.getLibraryCard());
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A borrower was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean updateborrower(int bid, String name, String email, int phone, boolean lib_card) {
		String query="UPDATE borrower SET name=? email=?, phone=?, libcard=? WHERE bid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(5, bid);
			ps.setString(1,name);
			ps.setString(2, email);
			ps.setInt(3, phone);
			ps.setBoolean(4, lib_card);
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A borrower was updated...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	
	public boolean deleteborrower(int bid) {
		String query="DELETE FROM borrower WHERE bid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, bid);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A borrower was deleted...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	//Book
	
	public ArrayList<Book> readbook() {
		ArrayList<Book> book = new ArrayList<Book>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM book";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Book b = new Book(rs.getString(2), rs.getString(3), rs.getBoolean(4),rs.getInt(1));
				book.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	public void savebook(Book b) {
		try {
			String query="INSERT INTO book (bookid, title, author, borrowed) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, b.getBookid());
			stmt.setString(3, b.getAuthor());
			stmt.setString(2, b.getTitle());
			stmt.setBoolean(4, b.getborrowed());

			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A book was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean updatebook(int Book_id, String title, String author, boolean borrowed) {
		String query="UPDATE borrower SET title=? author=?, borrowed=? WHERE bookid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(4, Book_id);
			ps.setString(1,title);
			ps.setString(2, author);
			ps.setBoolean(3, borrowed);
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A book was updated...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	
	public boolean deletebook(int bookid) {
		String query="DELETE FROM book WHERE bookid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, bookid);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A book was deleted...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//Librarian
	
	public ArrayList<Librarian> readlib() {
		ArrayList<Librarian> lib = new ArrayList<Librarian>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM librarian";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Librarian l = new Librarian(rs.getInt(1), rs.getString(2), rs.getString(3));
				lib.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lib;
	}

	public void savelib(Librarian l) {
		try {
			String query="INSERT INTO librarian (lid, name, pass) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, l.getLibrarianid());
			stmt.setString(2, l.getName());
			stmt.setString(3, l.getPassword());

			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A librarian was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean updatelib(int id, String name, String pass) {
		String query="UPDATE librarian SET name=? pass=? WHERE lid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(3, id);
			ps.setString(1,name);
			ps.setString(2, pass);
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A book was updated...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	


	//Borrowed
	
	public ArrayList<Borrowed> readborr() {
		ArrayList<Borrowed> borr = new ArrayList<Borrowed>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM borrowed";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Borrowed b = new Borrowed(rs.getInt(2), rs.getInt(1));
				borr.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borr;
	}

	public void saveborr(Borrowed b) {
		try {
			String query="INSERT INTO borrowed (bookid, userid) VALUES (?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, b.getBookid());
			stmt.setInt(1, b.getUserid());

			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A borrowed book entry was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean updateborrowed(int bookid, int userid) {
		String query="UPDATE borrowed SET bookid=? WHERE userid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, bookid);
			ps.setInt(2,userid);

			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A borrowed book entry was updated...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	
	public boolean deleteborr(int userid) {
		String query="DELETE FROM book WHERE userid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, userid);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A borrowed book entry was deleted...");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Book> searchbook(String keyword) {
	    ArrayList<Book> result = new ArrayList<Book>();
	    try {
	        String query = "SELECT * FROM book WHERE title LIKE ?";
	        PreparedStatement stmt = con.prepareStatement(query);
	        stmt.setString(1, "%" + keyword + "%");
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            int bookid = rs.getInt("bookid");
	            String title = rs.getString("title");
	            String author = rs.getString("author");
	            boolean borrowed = rs.getBoolean("borrowed");
	            Book b = new Book(title, author, borrowed, bookid);
	            result.add(b);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return result;
	}

	//CLOSE CONNECTION
	
	public void closeConnection() {
		try {

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
