package Model;

public class Category_tour {
	private int id_cate;
	private String name_cate;

	public Category_tour() {
	}

	public Category_tour(int id_cate, String name_cate) {
		super();
		this.id_cate = id_cate;
		this.name_cate = name_cate;
	}

	public int getId_cate() {
		return id_cate;
	}

	public void setId_cate(int id_cate) {
		this.id_cate = id_cate;
	}

	public String getName_cate() {
		return name_cate;
	}

	public void setName_cate(String name_cate) {
		this.name_cate = name_cate;
	}

	@Override
	public String toString() {
		return "Category_tour [id_cate=" + id_cate + ", name_cate=" + name_cate + "]";
	}

	
}
