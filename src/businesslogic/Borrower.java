package businesslogic;

public class Borrower {
	private int b_id;
	private int phone;
	private String b_name;
	private String email;
	private String password;
	private boolean lib_card; 
	private boolean form = false;

	public Borrower(int bid, int phone, String name, String email, String pass, boolean lib_card) {
	
		this.b_id = bid;
		this.phone = phone;
		this.b_name = name;
		this.email = email;
		this.password = pass;
		this.lib_card = lib_card;
	}
	
	public int getBorrowerid() {
		return b_id;
	}
	public void setborrowerid(int id) {
		this.b_id = id;
	}
	public int getPhoneNumber() {
		return phone;
	}
	public void setPhoneNumber(int phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return b_name;
	}
	public void setName(String name) {
		this.b_name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public boolean getLibraryCard() {
		return lib_card;
	}
	public void setLibraryCard(Boolean libcard) {
		this.lib_card = libcard;
	}
	

	@Override
	public String toString() {
		return "Borrower [b_id=" + b_id + ", phone=" + phone + ", b_name=" + b_name + ", email=" + email + ", password="
				+ password + ", lib_card=" + lib_card + ", form=" + form + "]";
	}

	public boolean isForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}
	
}
