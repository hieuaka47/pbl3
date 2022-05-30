package DAO;

import java.util.List;

import Model.Category_tour;

public interface Category_tourDAO {

	// thêm danh mục mới
	public void addCategory(Category_tour c);

	public void delCategory(int id_cate);

	// danh sach
	public List<Category_tour> getAllCategory();

	public Category_tour getCategoryById(int id_cate);
	
	public void updateCategory(Category_tour c);

}