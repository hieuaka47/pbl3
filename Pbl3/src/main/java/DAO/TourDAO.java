package DAO;

import java.util.List;

import Model.Tour;

public interface TourDAO {
	// hiển thị danh sách Tour
	public List<Tour> getAllTour();

	// thêm Tour mới
	public void addTour(Tour t);


	// lấy danh sách Tour dựa vào Category
	public List<Tour> getListByCategory(int id_cate);
	
	public Tour getTour(int id_tour);
	
	public List<Tour> searchTour(String tour_name);

}
