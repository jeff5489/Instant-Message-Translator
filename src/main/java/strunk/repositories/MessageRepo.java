package strunk.repositories;

import java.util.List;

import strunk.entities.Message;

public interface MessageRepo {
	//crud
	public Message addMessage(Message message);
	public List<Message> getMessages();
	public Message getMessage(int id);
	public Message updateMessage(Message message);
	public boolean deleteMessage(int id);
}
