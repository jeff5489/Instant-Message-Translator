package strunk.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import strunk.entities.Message;
import strunk.entities.User;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User addUser(User user) {
		Session sess = sf.openSession();
		int id;
		
		try {
			sess.beginTransaction();
			id = Integer.parseInt(sess.save(user).toString());
			sess.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session sess = sf.openSession();
		List<User> users = null;

		try {
			users = sess.createQuery("FROM message").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return users;
	}

	@Override
	public User getUser(int id) {
		Session sess = sf.openSession();
		User user = null;

		try {
			user = sess.get(User.class, id);

		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		Session sess = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(sess.get(User.class, id));
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
