package Model;

import java.util.Date;

public class Blog {
    private int id_blog;
    private String name_blog;
    private String description;
    private Date dataSubmit;
    private Category_blog Cateid;
    private String link;
    private String img;

    public Blog() {
    }

	public Blog(int id_blog, String name_blog, String description, Date dataSubmit, Category_blog cateid, String link,
			String img) {
		super();
		this.id_blog = id_blog;
		this.name_blog = name_blog;
		this.description = description;
		this.dataSubmit = dataSubmit;
		this.Cateid = cateid;
		this.link = link;
		this.img = img;
	}

	public int getId_blog() {
		return id_blog;
	}

	public void setId_blog(int id_blog) {
		this.id_blog = id_blog;
	}

	public String getName_blog() {
		return name_blog;
	}

	public void setName_blog(String name_blog) {
		this.name_blog = name_blog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDataSubmit() {
		return dataSubmit;
	}

	public void setDataSubmit(Date dataSubmit) {
		this.dataSubmit = dataSubmit;
	}

	public Category_blog getCateid() {
		return Cateid;
	}

	public void setCateid(Category_blog cateid) {
		this.Cateid = cateid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Blog [id_blog=" + id_blog + ", name_blog=" + name_blog + ", description=" + description
				+ ", dataSubmit=" + dataSubmit + ", Cateid=" + Cateid + ", link=" + link + ", img=" + img + "]";
	}

    
}
