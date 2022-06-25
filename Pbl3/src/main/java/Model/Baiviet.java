package Model;

import java.util.Objects;

public class Baiviet {
	private int idbaiviet;
	private int idlocation;
	private String title;
	private String brief;
	private String noidung;
	private String img;
	private String img2;
	private String img3;
	private String img4;
	
	
	public Baiviet() {
		
	}
	public Baiviet(int idbaiviet, int idlocation,String title,String brief,String noidung, String img,String img2,String img3,String img4) {
		this.idbaiviet = idbaiviet;
		this.idlocation = idlocation;
		this.title = title;
		this.brief= brief;
		this.noidung= noidung;
		this.img=img;
		this.img2=img2;
		this.img3=img3;
		this.img4=img4;
		
	}
	public int getIdbaiviet() {
		return idbaiviet;
	}
	public void setIdbaiviet(int idbaiviet) {
		this.idbaiviet = idbaiviet;
	}
	public int getIdlocation() {
		return idlocation;
	}
	public void setIdlocation(int idlocation) {
		this.idlocation = idlocation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	
	}
	
	
	 

	
	
	
	

	


