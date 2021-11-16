package view;

import java.awt.EventQueue;

import configuration.ReadXMLDomParser;
import dao.daoImpl.UserDao;
import objects.User;
import views.Login;

public class HibernateApp {
	
	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();

		User user1 = new User("ladyangel", "angiemarie@hotmail.com", "12345");
		userDao.save(user1);
		User user2 = new User("lady", "angiemarie1@hotmail.com", "12345");
		userDao.save(user2);

	}

}
