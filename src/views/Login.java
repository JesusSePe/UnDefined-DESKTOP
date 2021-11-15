package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exception.ErrorControl;
import configuration.ReadXMLDomParser;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JCheckBox;

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
			public void run() {
				try {
					App apphibernate = new App();
					apphibernate.main(args);
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
		ImageIcon img = new ImageIcon("src"+File.separator+"images"+File.separator+"logoKadamm.PNG");
		setIconImage(img.getImage());
		setResizable(false);
		setSize(450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("src"+File.separator+"images"+File.separator+"movilLoginDegr.png"));
		label_1.setBounds(240, -35, 235, 350);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src"+File.separator+"images"+File.separator+"trofeoLoginDegr.png"));
		label.setBounds(-25, -35, 235, 350);
		contentPane.add(label);
		
		JLabel lblKadamm = new JLabel("KADAMM");
		lblKadamm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKadamm.setForeground(Color.CYAN);
		lblKadamm.setFont(new Font("Chiller", Font.BOLD, 70));
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
				List<User> users = userDao.getAll();
				for(User element: users) {
					System.out.println(element);
					if (element.getUsername().equals(textField.getText())){
							if(element.getPassword().equals(String.valueOf(passwordField.getPassword()))){
								KadammManagement kadammManagemente = new KadammManagement();
								kadammManagemente.main(null);
							}else {
								new ErrorControl("Password incorrect", "Warning");
							}
					}else {
						new ErrorControl("Not found user!", "Error");
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
