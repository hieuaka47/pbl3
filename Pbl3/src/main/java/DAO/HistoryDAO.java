package DAO;

import java.util.List;

import Model.Bill;
import Model.History;

public interface HistoryDAO {

	// add bill vào database
	public void addHistory(Bill bill);

	public List<History> getList(int user_id);// Lấy list history trong database theo từng user thông qua id_user

	public List<History> getListAll();// Lấy all list history trong database , cái này của Manager

	public double getTotalMoneyInCurrenMonth();

	public double getTotalMoney();
}
