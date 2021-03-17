package strunk.repositories;

import java.util.List;

import strunk.entities.User;

public interface UserRepo {
	
	public User addUser(User user);
	public List<User> getUsers();
	public User getUser(int id);
	public User updateUser(User user);
	public boolean deleteUser(int id);

}
