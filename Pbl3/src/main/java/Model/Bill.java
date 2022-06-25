package Model;


public class Bill {
	 private int id;
	 private int id_tour;
	 private int id_user;
	 private String name_tour;
	 private int price;
	 private String username;
	 private String buyDate;
	 private User buyer;
	 private Tour tour;
	 private int amount_tour;
	public Bill() {
	    
	 }
	public Bill(int id, int id_tour, String name_tour, int price, String username, String buyDate, User buyer,Tour tour, int amount_tour) {
		super();
		this.id = id;
		this.id_tour = id_tour;
		this.name_tour = name_tour;
		this.price = price;
		this.username = username;
		this.buyDate = buyDate;
		this.buyer = buyer;
		this.tour = tour;
		this.amount_tour= amount_tour;
	}
	 public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getAmount_tour() {
		return amount_tour;
	}
	public void setAmount_tour(int amount_tour) {
		this.amount_tour = amount_tour;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	 public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTour() {
		return id_tour;
	}
	public void setIdTour(int id_tour) {
		this.id_tour = id_tour;
	}
	public String getName_tour() {
		return name_tour;
	}
	public void setName_tour(String name_tour) {
		this.name_tour = name_tour;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public java.sql.Date getCreateDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", id_tour=" + id_tour + ", id_user=" + id_user + ", name_tour=" + name_tour
				+ ", price=" + price + ", username=" + username + ", buyDate=" + buyDate + ", buyer=" + buyer
				+ ", tour=" + tour + ", amount_tour=" + amount_tour + "]";
	}
	
	
}
