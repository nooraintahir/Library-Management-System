package businesslogic;

public class Librarian {
	private int L_id;
	private String L_name;
	private String password;
	
	

	public Librarian(int id,  String name, String pass) {
	
		this.L_id = id;
		this.L_name = name;
		this.password = pass;
		
	}
	
	public int getLibrarianid() {
		return L_id;
	}
	public void setLibrarianid(int id) {
		this.L_id = id;
	}
	
	
	public String getName() {
		return L_name;
	}
	public void setName(String name) {
		this.L_name = name;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	
	@Override
	public String toString() {
		return "Librarian [Librarian=" + L_id + ",  name=" + L_name + ",  password= "+ password +", ]";
	}
	
}
