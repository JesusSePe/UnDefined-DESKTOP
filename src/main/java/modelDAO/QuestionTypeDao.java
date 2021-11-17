package modelDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtils.HibernateUtil;
import Objects.QuestionType;

public class QuestionTypeDao {

	public QuestionType getQuestionTypeById(long id) {
		Transaction transaction = null;
		QuestionType questionType = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			questionType = session.get(QuestionType.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return questionType;
	}

	@SuppressWarnings("unchecked")
	public List<QuestionType> getAllQuestions() {
		Transaction transaction = null;
		List<QuestionType> questionTypes = new ArrayList<QuestionType>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			questionTypes = session.createQuery("from question_type").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return questionTypes;
	}

	public void saveQuestionType(QuestionType questionType) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(questionType);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public void updateQuestionType(QuestionType questionType) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(questionType);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public void deleteQuestionType(QuestionType questionType) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.delete(questionType);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	public QuestionType getQuestionTypebyTypeName(String questionTypeText) {
		return null;
	}

}
