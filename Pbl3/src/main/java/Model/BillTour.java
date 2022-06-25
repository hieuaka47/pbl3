package Model;

import java.sql.Timestamp;

public class BillTour {
	private int id;
	private Double unitPrice;
	private int quantity;
	private int quantity_people;
	private Timestamp Date_time;
	private int id_tour;
	private int user_id;
	private Tour tour;
	private Bill bill;
	private String list_name_tour;
	public String getList_name_tour() {
		return list_name_tour;
	}
	public void setList_name_tour(String list_name_tour) {
		this.list_name_tour = list_name_tour;
	}
	public int getQuantity_people() {
		return quantity_people;
	}
	public void setQuantity_people(int quantity_people) {
		this.quantity_people = quantity_people;
	}
	public Timestamp getDate_time() {
		return Date_time;
	}
	public void setDate_time(Timestamp date_time) {
		Date_time = date_time;
	}
	public int getId_tour() {
		return id_tour;
	}
	public void setId_tour(int id_tour) {
		this.id_tour = id_tour;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
