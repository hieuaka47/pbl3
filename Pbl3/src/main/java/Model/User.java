package Model;

import java.sql.Date;

public class User {
	private int user_id;
	private String username;
	private String hoten;
	private String email;
	private String password;
	private java.sql.Date ngaysinh;
	private boolean gioitinh;
	private String sdt;
	private String diachi;
	private String role;
	
	public User() {
		
	}

	public User(int user_id, String username, String hoten, String email, String password, Date ngaysinh,
			boolean gioitinh, String sdt, String diachi, String role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.hoten = hoten;
		this.email = email;
		this.password = password;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.diachi = diachi;
		this.role = role;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public java.sql.Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(java.sql.Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", hoten=" + hoten + ", email=" + email
				+ ", password=" + password + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", sdt=" + sdt
				+ ", diachi=" + diachi + ", role=" + role + "]";
	}
}
