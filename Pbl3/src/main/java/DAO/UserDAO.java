package DAO;

import java.util.List;

import Model.User;

public interface UserDAO {
	
	public void addUser(User u);
	
	public boolean checkUser(String username);
	
	public boolean login(String username, String password);
	
	public void updateUser(User u);
	
	public List<User> getAllUser();
	
	public User getUser(String username);
	
	public User findUserByPhone(String phone_user);
	
	public User findUserByEmail(String phone_user);
	
	public List<User> sortUser(String col, String mode);
}
