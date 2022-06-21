package Model;

import java.util.Date;

public class Tour {
	private int id_tour;
	private Category_tour cateID;
	private String name_tour;
	private String img;
	private Double price;
	private String duration;
	private Date date_start;
	private String pickup_locations;
	private int quantity_max_people;
	
	public Tour() {
		
	}

	public Tour(int id_tour, Category_tour cateID, String name_tour, String img, Double price, String duration,
			Date date_start, String pickup_locations, int quantity_max_people) {
		super();
		this.id_tour = id_tour;
		this.cateID = cateID;
		this.name_tour = name_tour;
		this.img = img;
		this.price = price;
		this.duration = duration;
		this.date_start = date_start;
		this.pickup_locations = pickup_locations;
		this.quantity_max_people = quantity_max_people;
	}

	public int getId_tour() {
		return id_tour;
	}

	public void setId_tour(int id_tour) {
		this.id_tour = id_tour;
	}

	public Category_tour getCateID() {
		return cateID;
	}

	public void setCateID(Category_tour cateID) {
		this.cateID = cateID;
	}

	public String getName_tour() {
		return name_tour;
	}

	public void setName_tour(String name_tour) {
		this.name_tour = name_tour;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public String getPickup_locations() {
		return pickup_locations;
	}

	public void setPickup_locations(String pickup_locations) {
		this.pickup_locations = pickup_locations;
	}

	public int getQuantity_max_people() {
		return quantity_max_people;
	}

	public void setQuantity_max_people(int quantity_max_people) {
		this.quantity_max_people = quantity_max_people;
	}

	@Override
	public String toString() {
		return "Tour [id_tour=" + id_tour + ", cateID=" + cateID + ", name_tour=" + name_tour + ", img=" + img
				+ ", price=" + price + ", duration=" + duration + ", date_start=" + date_start + ", pickup_locations="
				+ pickup_locations + ", quantity_max_people=" + quantity_max_people + "]";
	}

}
