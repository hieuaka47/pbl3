package DAO;

import java.util.List;

import Model.Category_blog;
import Model.Category_tour;

public interface Category_blogDAO {
	// thêm danh mục mới
	public void addCategory(Category_blog c);

	public void delCategory(int id_cate);

	// danh sach
	public List<Category_blog> getAllCategory();

	public Category_blog getCategoryById(int id_cate);
	
	public void updateCategory(Category_blog c);
}
