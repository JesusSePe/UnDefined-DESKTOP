package modelDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import Objects.UserAnswerHistory;

public class UserQuestionHistoryDao {

	public UserAnswerHistory getAnswerHistoryById(long id) {
		Transaction transaction = null;
		UserAnswerHistory userQuestionHistory = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			userQuestionHistory = session.get(UserAnswerHistory.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return userQuestionHistory;
	}

	@SuppressWarnings("unchecked")
	public List<UserAnswerHistory> getAllUserAnswerHistory() {
		Transaction transaction = null;
		List<UserAnswerHistory> players = new ArrayList<UserAnswerHistory>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			players = session.createQuery("from user_question_history").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return players;
	}

	public void saveAnswerHistory(UserAnswerHistory userQuestionHistory) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(userQuestionHistory);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateUserAnswerHistory(UserAnswerHistory userQuestionHistory) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(userQuestionHistory);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public void deleteUserAnswerHistory(UserAnswerHistory userQuestionHistory) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.delete(userQuestionHistory);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
