package modelDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import Objects.Player;

public class PlayerDao {

	public Player get(long id) {
		Transaction transaction = null;
		Player player = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			player = session.get(Player.class, id);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

		return player;
	}

	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {
		Transaction transaction = null;
		List<Player> players = new ArrayList<Player>();

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			players = session.createQuery("from player").list();

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

		return players;
	}

	public void savePlayer(Player player) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.save(player);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
	}

	public void updatePlayer(Player player) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.saveOrUpdate(player);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}
		
	}

	public void deletePlayer(Player player) {
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			session.delete(player);

			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();	
			}
		}

	}

	public Player getPlayerByNickname(String nickname) {
		return null;
	}

}
