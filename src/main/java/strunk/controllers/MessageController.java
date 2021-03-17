package strunk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import strunk.entities.Message;
import strunk.services.MessageService;

public class MessageController {
	
	@Autowired
	MessageService service;

	@GetMapping(value = "/messages", produces = "application/json")
	public List<Message> getAllActors() {
		return service.getMessages();
	}

	@GetMapping(value = "/messages/{id}")
	public Message getActor(@PathVariable("id") int id) {
		return service.getMessage(id);
	}
	
	@PostMapping(value = "/messages", consumes = "application/json", produces = "application/json")
	public Message addActor(@RequestBody Message message) {
		return service.addMessage(message);
	}
	
	@DeleteMapping(value = "/messages/{id}")
	public boolean deleteActor(@PathVariable("id") int id) {
		return service.deleteMessage(id);
	}

}
