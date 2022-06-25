package DAO;

import java.util.List;

import Model.Tour;

public interface TourDAO {
	// hiển thị danh sách Tour
	public List<Tour> getAllTour();

	// thêm Tour mới
	public void addTour(Tour t);

	public void updateTour(Tour t);

	public void deleteTour(int id);

	// lấy danh sách Tour dựa vào Category
	public List<Tour> getListByCategory(int id_cate);

	public Tour getTour(int id_tour);

	public int getTotalTour(String action, String idCate, String search, String modeSort);

	public List<Tour> pagingTour(int index, String action, String idCate, String search, String modeSort);

}
