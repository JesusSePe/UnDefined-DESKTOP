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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KadammCreator extends JFrame {

	private static final long serialVersionUID = -7760529119031318954L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KadammCreator frame = new KadammCreator();
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
	@SuppressWarnings("rawtypes")
	public KadammCreator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CREATE KADAMM");
		ImageIcon img = new ImageIcon("src" + File.separator +"main"+File.separator+"java"+File.separator+"images"+File.separator+"logoKadamm.PNG");
		setIconImage(img.getImage());
		setResizable(false);
		setSize(675, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#374151"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKadamms = new JLabel("TITULO");
		lblKadamms.setForeground(new Color(175, 238, 238));
		lblKadamms.setBounds(23, 20, 38, 17);
		contentPane.add(lblKadamms);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 213, 390, 83);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton_1 = new JButton("Afegir pregunta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(160, 370, 166, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Guardar nou Kadamm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(349, 370, 166, 36);
		contentPane.add(btnNewButton_4);
		
		JLabel lblChosenTopics = new JLabel("Respostes");
		lblChosenTopics.setForeground(new Color(175, 238, 238));
		lblChosenTopics.setBounds(428, 192, 85, 17);
		contentPane.add(lblChosenTopics);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(428, 72, 225, 110);
		contentPane.add(scrollPane_1_1);
		
		JList list_1 = new JList();
		scrollPane_1_1.setViewportView(list_1);
		
		JLabel lblTopics = new JLabel("Temes associats");
		lblTopics.setForeground(new Color(175, 238, 238));
		lblTopics.setBounds(428, 52, 106, 17);
		contentPane.add(lblTopics);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 72, 390, 110);
		contentPane.add(scrollPane_1);
		
		JList list_3 = new JList();
		scrollPane_1.setViewportView(list_3);
		
		JLabel lblKadamms_1 = new JLabel("Llista de preguntes");
		lblKadamms_1.setForeground(new Color(175, 238, 238));
		lblKadamms_1.setBounds(23, 52, 126, 17);
		contentPane.add(lblKadamms_1);
		
		JLabel lblKadamms_1_1 = new JLabel("Nova pregunta");
		lblKadamms_1_1.setForeground(new Color(175, 238, 238));
		lblKadamms_1_1.setBounds(23, 192, 106, 17);
		contentPane.add(lblKadamms_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Seleccionant 1 resposta");
		rdbtnNewRadioButton.setBounds(252, 328, 170, 25);
		rdbtnNewRadioButton.setSelected(true);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblKadamms_1_1_1 = new JLabel("Com es contesta");
		lblKadamms_1_1_1.setForeground(new Color(175, 238, 238));
		lblKadamms_1_1_1.setBounds(252, 308, 106, 17);
		contentPane.add(lblKadamms_1_1_1);
		
		JLabel lblCorrecta = new JLabel("Correcta");
		lblCorrecta.setForeground(new Color(175, 238, 238));
		lblCorrecta.setBounds(608, 192, 55, 17);
		contentPane.add(lblCorrecta);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(625, 213, 21, 21);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(625, 234, 21, 21);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_1_1 = new JCheckBox("");
		checkBox_1_1.setBounds(625, 255, 21, 21);
		contentPane.add(checkBox_1_1);
		
		JCheckBox checkBox_1_1_1 = new JCheckBox("");
		checkBox_1_1_1.setBounds(625, 276, 21, 21);
		contentPane.add(checkBox_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(73, 18, 340, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(428, 213, 180, 83);
		contentPane.add(scrollPane_2);
		
		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
	}

}