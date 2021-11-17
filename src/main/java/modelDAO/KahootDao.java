package modelDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import Objects.Kahoot;

public class KahootDao {

	public Kahoot getKahootById(long id) {
		Transaction transaction = null;
		Kahoot kahoot = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			kahoot = session.get(Kahoot.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return kahoot;
	}

	@SuppressWarnings("unchecked")
	public List<Kahoot> getAllKahoots() {
		Transaction transaction = null;
		List<Kahoot> kahoots = new ArrayList<Kahoot>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			kahoots = session.createQuery("from kahoot").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return kahoots;
	}

	public void saveKahoot(Kahoot kahoot) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(kahoot);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateKahoot(Kahoot kahoot) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(kahoot);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public void deleteKahoot(Kahoot kahoot) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.delete(kahoot);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public Kahoot getKahootByTitle (String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
