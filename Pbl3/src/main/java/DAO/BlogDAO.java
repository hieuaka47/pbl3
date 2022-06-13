package DAO;

import java.util.List;

import Model.Blog;

public interface BlogDAO {
	// hiển thị danh sách 
	public List<Blog> getAllBlog();

	// thêm 
	public void addBlog(Blog b);


	// lấy danh sách  dựa vào Category
	public List<Blog> getListByCategory(int id_category);
	
	public Blog getBlog(int id_blog);
	
	public List<Blog> searchBlog(String blog_name);
}
