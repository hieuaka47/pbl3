package Model;

public class Category_tour {
	private int id_cate;
	private String name;

	public Category_tour() {
	}

	public Category_tour(int id_cate, String name) {
		super();
		this.id_cate = id_cate;
		this.name = name;
	}

	public int getId_cate() {
		return id_cate;
	}

	public void setId_cate(int id_cate) {
		this.id_cate = id_cate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
