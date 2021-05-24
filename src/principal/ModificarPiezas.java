package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;

public class ModificarPiezas extends JFrame {

	private JPanel contentPane;
	private ConexionBBDD conexion;
	

	public ModificarPiezas() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarPiezas.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		conexion=new ConexionBBDD();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width/2,pantalla.height/2);
		setTitle("Genti\u00F3n Empresarial");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ModificarPiezas.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		lblLogo.setBounds(164, 11, 237, 59);
		contentPane.add(lblLogo);
		
		
		
}
}