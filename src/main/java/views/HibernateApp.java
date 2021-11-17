package views;

import java.io.File;
import java.util.List;

import Objects.Answer;
import Objects.Kahoot;
import Objects.Question;
import Objects.QuestionType;
import Objects.Topic;
import Objects.User;
import modelDAO.AnswerDao;
import modelDAO.KahootDao;
import modelDAO.QuestionDao;
import modelDAO.QuestionTypeDao;
import modelDAO.TopicDao;
import modelDAO.UserDao;

public class HibernateApp {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		/*
		 * User user5 = new User("pol", "pol@hotmail.com", "123");
		 * userDao.saveUser(user5); User user6 = new User("jesus", "jesus@hotmail.com",
		 * "123"); userDao.saveUser(user6);
		 */
		User user3 = userDao.getUserById(1);
		User user4 = userDao.getUserByName("lady"); //Esto no va
		System.out.println(user3);
		System.out.println(user4);

		List <User>users = userDao.getAllUsers();

		for(User element: users) {
			System.out.println(element);
		}
		//String topic
		Topic topic1 = new Topic("Peliculas");
		Topic topic2 = new Topic("Matematicas");
		Topic topic3 = new Topic("Conocimiento General");
		Topic topic4 = new Topic("Musica");

		//Guardamos
		TopicDao topicDao = new TopicDao();
		topicDao.saveTopic(topic1);
		topicDao.saveTopic(topic2);
		topicDao.saveTopic(topic3);
		topicDao.saveTopic(topic4);


		KahootDao kahootDao = new KahootDao();
		//String title, String description, String language, String image, boolean isFavorite
		Kahoot kahoot1 = new Kahoot("Peliculas infantiles y superheroes", "ES", "Peliculas Marvel","src" + File.separator +"main"+File.separator+"java"+File.separator+"images"+File.separator+"logoKadamm.PNG",true);
		kahootDao.saveKahoot(kahoot1);

		//String text, long timeout, String score, String answerOption
		QuestionType questionType1 = new QuestionType("Quiz", 30, "Estandar", "Seleccion simple");
		QuestionType questionType2 = new QuestionType("Verdadero-Falso", 30, "Estandar", "Seleccion simple");
		QuestionType questionType3 = new QuestionType("Pregunta Abierta", 120, "Estandar", "Seleccion simple");

		QuestionTypeDao questionTypeDao = new QuestionTypeDao();
		questionTypeDao.saveQuestionType(questionType1);
		questionTypeDao.saveQuestionType(questionType2);
		questionTypeDao.saveQuestionType(questionType3);

		//String questionText
		Question question1 = new Question("¿Cuál es el verdadero nombre de Iron Man?");
		Question question2 = new Question("¿Cuando este doctor se enoja, se transforma en Hulk?");
		Question question3 = new Question("¿Como se llama el hermano de Thor?");
		Question question4 = new Question("¿Cuantas gemas tiene que reunir Thanos en su guante?");

		question1.setQuestionType(questionType1);
		question2.setQuestionType(questionType1);
		question3.setQuestionType(questionType1);
		question4.setQuestionType(questionType1);

		question1.setKahoot(kahoot1);
		question2.setKahoot(kahoot1);
		question3.setKahoot(kahoot1);
		question4.setKahoot(kahoot1);
		
		QuestionDao questionDao = new QuestionDao();
		questionDao.saveQuestion(question1);
		questionDao.saveQuestion(question2);
		questionDao.saveQuestion(question3);
		questionDao.saveQuestion(question4);

		//String answerText, Question question, boolean isCorrect
		Answer answer1 = new Answer("Bruce Waine", question1, false);
		Answer answer2 = new Answer("Tony Stark", question1, true);
		Answer answer3 = new Answer("Oliver Queen", question1, true);
		Answer answer4 = new Answer("Peter Parker", question1, true);

		Answer answer5 = new Answer("Dr. Strange", question2, false);
		Answer answer6 = new Answer("Dr. Who", question2, false);
		Answer answer7 = new Answer("Dr. Doom", question2, false);
		Answer answer8 = new Answer("Dr. Banner", question2, false);

		Answer answer9 = new Answer("Asgard", question3, false);
		Answer answer10 = new Answer("Odin", question3, false);
		Answer answer11 = new Answer("Heimdall", question3, false);
		Answer answer12 = new Answer("Loki", question3, false);

		Answer answer13 = new Answer("4", question4, false);
		Answer answer14 = new Answer("5", question4, false);
		Answer answer15 = new Answer("2", question4, true);
		Answer answer16 = new Answer("6", question4, false);

		AnswerDao answerDao = new AnswerDao();
		answerDao.saveAnswer(answer1);
		answerDao.saveAnswer(answer2);
		answerDao.saveAnswer(answer3);
		answerDao.saveAnswer(answer3);
		answerDao.saveAnswer(answer4);
		answerDao.saveAnswer(answer5);
		answerDao.saveAnswer(answer6);
		answerDao.saveAnswer(answer7);
		answerDao.saveAnswer(answer8);
		answerDao.saveAnswer(answer9);
		answerDao.saveAnswer(answer10);
		answerDao.saveAnswer(answer11);
		answerDao.saveAnswer(answer12);
		answerDao.saveAnswer(answer13);
		answerDao.saveAnswer(answer14);
		answerDao.saveAnswer(answer15);
		answerDao.saveAnswer(answer16);


	}

}
