package strunk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import strunk.entities.User;
import strunk.services.UserService;

public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping(value = "/users", produces = "application/json")
	public List<User> getAllActors() {
		return service.getUsers();
	}

	@GetMapping(value = "/users/{id}")
	public User getActor(@PathVariable("id") int id) {
		return service.getUser(id);
	}
	
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User addActor(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@DeleteMapping(value = "/users/{id}")
	public boolean deleteActor(@PathVariable("id") int id) {
		return service.deleteUser(id);
	}

}
