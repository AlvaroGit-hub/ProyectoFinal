package principal;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class Tablas extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	
	public Tablas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tablas.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tablas.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
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

}
