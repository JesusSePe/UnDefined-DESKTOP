package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
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
		ImageIcon img = new ImageIcon("logoKadamm.png");
		setIconImage(img.getImage());
		setResizable(false);
		setSize(450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(new Color(175, 238, 238));
		lblUser.setBounds(128, 100, 86, 17);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(175, 238, 238));
		lblPassword.setBounds(128, 135, 86, 17);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(216, 96, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 131, 100, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(170, 200, 110, 35);
		contentPane.add(btnLogin);
		
		JLabel lblKadamm = new JLabel("KADAMM");
		lblKadamm.setForeground(Color.CYAN);
		lblKadamm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKadamm.setFont(new Font("Chiller", Font.BOLD, 70));
		lblKadamm.setBounds(0, 25, 444, 61);
		contentPane.add(lblKadamm);
		
		JCheckBox chckbxRememberMyPassword = new JCheckBox("Remember my password");
		chckbxRememberMyPassword.setForeground(new Color(175, 238, 238));
		chckbxRememberMyPassword.setBounds(125, 165, 180, 25);
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
