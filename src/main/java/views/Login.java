package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Exception.ErrorControl;
import Objects.User;
import XMLconfig.ReadXMLDomParser;
import modelDAO.UserDao;


@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					//HibernateApp apphibernate = new HibernateApp();
					//apphibernate.main(args);
					ReadXMLDomParser readXMLDomParser = new ReadXMLDomParser();
					readXMLDomParser.readXML();
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("KADAMM");
		ImageIcon img = new ImageIcon("src" + File.separator +"main"+File.separator+"java"+File.separator+ "images" + File.separator + "logoKadamm.PNG");
		setIconImage(img.getImage());
		setResizable(false);
		setSize(450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("src" + File.separator + "main" + File.separator+"java"+File.separator + "images" + File.separator + "movilLoginDegr.png"));
		label_1.setBounds(240, -35, 235, 350);
		contentPane.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src" + File.separator +"main"+File.separator+"java"+File.separator + "images" + File.separator + "trofeoLoginDegr.png"));
		label.setBounds(-25, -35, 235, 350);
		contentPane.add(label);

		JLabel lblKadamm = new JLabel("KADAMM");
		lblKadamm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKadamm.setForeground(Color.CYAN);
		try {
		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src" + File.separator +"main"+File.separator+"java"+File.separator+"Utilities"+File.separator+"chiller.ttf")).deriveFont(Font.BOLD, 70);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(customFont);
		    lblKadamm.setFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		lblKadamm.setBounds(0, 21, 452, 61);
		contentPane.add(lblKadamm);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(216, 88, 100, 20);
		contentPane.add(textField);

		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(new Color(175, 238, 238));
		lblUser.setBounds(128, 92, 86, 17);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(175, 238, 238));
		lblPassword.setBounds(128, 127, 86, 17);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(216, 123, 100, 20);
		contentPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(170, 192, 110, 35);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserDao userDao = new UserDao();
				String name = textField.getText();
				
				/*
				User getUser = userDao.getUserByName(name);
				if (getUser != null) {
					if (getUser.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
						KadammManagement kadammManagemente = new KadammManagement();
						kadammManagemente.main(null);
					} else {
						new ErrorControl("Password incorrect", "Warning");
					}
				}
				*/
				
				List<User> users = userDao.getAllUsers();
				//System.out.println(users.size());
				int contador =0;
				for (User element : users) {
					contador++;
					//System.out.println(element.getUsername());
					if (name.compareTo(element.getUsername())==0) {
						if (element.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
							KadammManagement kadammManagemente = new KadammManagement();
							kadammManagemente.main(null);
							break;
						} else {
							new ErrorControl("Password incorrect", "Warning");
							break;
						}
					}
					if (contador == users.size()){
						new ErrorControl("No user found!", "Error");
					}
				}
				
			}
		});

		JCheckBox chckbxRememberMyPassword = new JCheckBox("Remember my password");
		chckbxRememberMyPassword.setForeground(new Color(175, 238, 238));
		chckbxRememberMyPassword.setBounds(125, 157, 180, 25);
		chckbxRememberMyPassword.setBackground(Color.decode("#374151"));
		contentPane.add(chckbxRememberMyPassword);
	}
}
