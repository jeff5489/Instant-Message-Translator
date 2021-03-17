package strunk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import strunk.entities.Message;
import strunk.repositories.MessageRepo;

public class MessageServiceImpl implements MessageRepo{
	
	@Autowired
	private MessageRepo repo;

	@Override
	public Message addMessage(Message message) {
		return repo.addMessage(message);
	}

	@Override
	public List<Message> getMessages() {
		return repo.getMessages();
	}

	@Override
	public Message getMessage(int id) {
		return repo.getMessage(id);
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMessage(int id) {
		return repo.deleteMessage(id);
	}

	
}
