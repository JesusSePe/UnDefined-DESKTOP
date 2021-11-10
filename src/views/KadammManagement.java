package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

public class KadammManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KadammManagement frame = new KadammManagement();
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
	public KadammManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("KADAMM");
		ImageIcon img = new ImageIcon("src"+File.separator+"images"+File.separator+"logoKadamm.PNG");
		setIconImage(img.getImage());
		setResizable(false);
		setBounds(100, 100, 675, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKadamms = new JLabel("Kadamms");
		lblKadamms.setForeground(new Color(175, 238, 238));
		lblKadamms.setBounds(23, 12, 60, 17);
		contentPane.add(lblKadamms);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 33, 390, 300);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("View Detail");
		btnNewButton.setBounds(225, 345, 190, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PLAY");
		btnNewButton_1.setBounds(124, 382, 190, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create Kadamm");
		btnNewButton_2.setBounds(23, 345, 190, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Filter by Topic");
		btnNewButton_3.setBounds(428, 345, 225, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Edit Topics");
		btnNewButton_4.setBounds(428, 382, 225, 27);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(428, 198, 225, 135);
		contentPane.add(scrollPane_1_1_1);
		
		JList list_2 = new JList();
		scrollPane_1_1_1.setViewportView(list_2);
		
		JLabel lblChosenTopics = new JLabel("Chosen Topics");
		lblChosenTopics.setForeground(new Color(175, 238, 238));
		lblChosenTopics.setBounds(428, 179, 85, 17);
		contentPane.add(lblChosenTopics);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(428, 33, 225, 135);
		contentPane.add(scrollPane_1_1);
		
		JList list_1 = new JList();
		scrollPane_1_1.setViewportView(list_1);
		
		JLabel lblTopics = new JLabel("Topics");
		lblTopics.setForeground(new Color(175, 238, 238));
		lblTopics.setBounds(428, 12, 38, 17);
		contentPane.add(lblTopics);
	}
}
