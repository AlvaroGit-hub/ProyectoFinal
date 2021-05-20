package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class Registros extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private Interfaz i;
	
	public Registros() {
		i= new Interfaz();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Registros.class.getResource("/interfaz/gemlogotransdefinitivopeque\u00F1o.png")));
		lblNewLabel.setBounds(545, 11, 75, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("Usuario :");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(40, 22, 75, 14);
		contentPane.add(lblUser);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setBounds(119, 22, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		setVisible(true);
	}

	
	public void nombreuser(String u) {	
		
			Interfaz i = new Interfaz();
			i.pasardatos(textField.getText());
			dispose();
			
		
	}
}
