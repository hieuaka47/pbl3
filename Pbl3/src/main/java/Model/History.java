package Model;

import java.sql.Timestamp;

public class History {
	private int id_history;
	private int user_id;
	private int id_tour;
	private int quantity;
	private Timestamp Date_time;
	private double price;
	public History() {
	}
	public History(int id_history, int user_id, int id_tour,int quantity ,Timestamp date_time, double price) {
		super();
		this.id_history = id_history;
		this.user_id = user_id;
		this.id_tour = id_tour;
		this.quantity = quantity;
		Date_time = date_time;
		this.price = price;
	}
	public int getId_history() {
		return id_history;
	}
	public void setId_history(int id_history) {
		this.id_history = id_history;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getId_tour() {
		return id_tour;
	}
	public void setId_tour(int id_tour) {
		this.id_tour = id_tour;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getDate_time() {
		return Date_time;
	}
	public void setDate_time(Timestamp date_time) {
		Date_time = date_time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
