package strunk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import strunk.entities.User;
import strunk.repositories.UserRepo;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public User addUser(User user) {
		return repo.addUser(user);
	}

	@Override
	public List<User> getUsers() {
		return repo.getUsers();
	}

	@Override
	public User getUser(int id) {
		return repo.getUser(id);
	}

	@Override
	public User updateUser(User user) {
		return repo.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return repo.deleteUser(id);
	}

}
