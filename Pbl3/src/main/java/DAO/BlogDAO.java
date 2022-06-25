package DAO;

import java.util.List;

import Model.Baiviet;
import Model.Diadiem;

public interface BlogDAO {

	public List<Baiviet> pagingBaiviet(int index);

	public int getTotalBlog();

	public int getTotalBlogByLID(String idlocation);

	public List<Baiviet> getAllBaiviet();

	public List<Diadiem> getAllLocation();

	public Diadiem getLocationById(int id);

	public List<Baiviet> getBaivietLID(String idlocation);

	public Baiviet getBaiviet(String id);

	public void addBaiviet(String idlocation, String title, String brief, String noidung, String img, String img2,
			String img3, String img4);

	public void deleteBaiviet(String qid);

	public void editBaiviet(String idlocation, String title, String brief, String noidung, String img, String img2,
			String img3, String img4, String pid);
}
