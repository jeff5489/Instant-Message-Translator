package strunk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import strunk.entities.Message;
import strunk.repositories.MessageRepoImpl;

@Service
public interface MessageService {
	
	public Message addMessage(Message message);
	public List<Message> getMessages();
	public Message getMessage(int id);
	public Message updateMessage(Message message);
	public boolean deleteMessage(int id);

}
 