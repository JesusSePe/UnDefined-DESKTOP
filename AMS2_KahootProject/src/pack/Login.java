package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JCheckBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private int width = 450;
	private int height = 300;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - width) / 2);
	    int y = (int) ((dimension.getHeight() - height) / 2);
	    System.out.println(x+" "+y);
		setBounds(458, 234, width, height);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(130, 100, 80, 17);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(130, 135, 80, 17);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(220, 96, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 131, 100, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(170, 200, 110, 35);
		contentPane.add(btnLogin);
		
		JLabel lblKadamm = new JLabel("KADAMM");
		lblKadamm.setForeground(Color.WHITE);
		lblKadamm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKadamm.setFont(new Font("Poor Richard", Font.BOLD, 52));
		lblKadamm.setBounds(0, 20, 444, 61);
		contentPane.add(lblKadamm);
		
		JCheckBox chckbxRememberMyPassword = new JCheckBox("Remember my password");
		chckbxRememberMyPassword.setForeground(Color.WHITE);
		chckbxRememberMyPassword.setBounds(130, 165, 180, 25);
		contentPane.add(chckbxRememberMyPassword);
		chckbxRememberMyPassword.setBackground(new Color(0,0,0,0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("trofeoLoginDegr.png"));
		label.setBounds(-25, -35, 235, 350);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("movilLoginDegr.png"));
		label_1.setBounds(240, -35, 235, 350);
		contentPane.add(label_1);
	}
}
