package views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class KadammWaitingRoom extends JFrame {

	private static final long serialVersionUID = 3057569290696129932L;
	private JPanel contentPane;
	private static String selectedTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String selected) {
		selectedTitle = selected;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KadammWaitingRoom frame = new KadammWaitingRoom();
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
	@SuppressWarnings({ "unchecked", "rawtypes", "serial", "unused" })
	public KadammWaitingRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("WAITING ROOM");
		ImageIcon img = new ImageIcon("src" + File.separator +"main"+File.separator+"java"+File.separator+"images"+File.separator+"logoKadamm.PNG");
		setIconImage(img.getImage());
		setResizable(false);
		setSize(450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKadamms = new JLabel("Chosen Kadamm: " + selectedTitle);
		lblKadamms.setHorizontalAlignment(SwingConstants.LEFT);
		lblKadamms.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKadamms.setForeground(new Color(175, 238, 238));
		lblKadamms.setBounds(12, 5, 423, 35);
		contentPane.add(lblKadamms);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 97, 330, 120);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("START COMPETITION");
		btnNewButton_1.setBounds(135, 230, 180, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				KadammCompetition kadammCompetition = new KadammCompetition();
				kadammCompetition.main(null);
				dispose();
			}
		});
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		
		
		String address;
		try {
			InetAddress IP=InetAddress.getLocalHost();
			JLabel lblKadamms_1 = new JLabel("IP: " + IP.getHostAddress());
			lblKadamms_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblKadamms_1.setForeground(new Color(175, 238, 238));
			lblKadamms_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblKadamms_1.setBounds(12, 35, 631, 35);
			contentPane.add(lblKadamms_1);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblKadamms_1_1 = new JLabel("Waiting for players...");
		lblKadamms_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblKadamms_1_1.setForeground(new Color(175, 238, 238));
		lblKadamms_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKadamms_1_1.setBounds(12, 70, 117, 27);
		contentPane.add(lblKadamms_1_1);
		
	}
	
}