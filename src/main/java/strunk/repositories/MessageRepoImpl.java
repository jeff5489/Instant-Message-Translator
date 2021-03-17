package strunk.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import strunk.entities.Message;

@Repository
public class MessageRepoImpl implements MessageRepo {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Message addMessage(Message message) {
		Session sess = sf.openSession();
		int id;
		
		try {
			sess.beginTransaction();
			id = Integer.parseInt(sess.save(message).toString());
			sess.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return message;

	}

	@Override
	public List<Message> getMessages() {
		Session sess = sf.openSession();
		List<Message> messages = null;

		try {
			messages = sess.createQuery("FROM message").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return messages;
	}

	@Override
	public Message getMessage(int id) {
		
		Session sess = sf.openSession();
		Message message = null;

		try {
			message = sess.get(Message.class, id);

		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return message;

	}

	@Override
	public Message updateMessage(Message message) {
		return null;
	}

	@Override
	public boolean deleteMessage(int id) {
		Session sess = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(sess.get(Message.class, id));
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
		return false;
	}

}
