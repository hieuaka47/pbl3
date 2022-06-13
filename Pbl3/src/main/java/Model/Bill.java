package Model;

public class Bill {
	private int id;
	private User buyer;
	private long priceTotal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public long getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}
}
