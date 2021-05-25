package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class AccesoLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private String id="";
	private ConexionBBDD conexion;

	public AccesoLogin() {
		
		conexion=new ConexionBBDD();
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccesoLogin.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		setTitle("Gesti\u00F3n Empresarial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPanelAdmin = new JButton("Panel administrador");
		btnPanelAdmin.setBounds(311, 320, 151, 23);
		contentPane.add(btnPanelAdmin);
		btnPanelAdmin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Login l=new Login();
			}
		});
		
		textId = new JTextField();
		textId.setBounds(161, 94, 176, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JButton btnBoton0 = new JButton("0");
		btnBoton0.setBounds(220, 258, 59, 45);
		contentPane.add(btnBoton0);
		btnBoton0.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="0";
				textId.setText(id);
			}
		});
		
		JButton btnBoton1 = new JButton("1");
		btnBoton1.setBounds(161, 125, 59, 45);
		contentPane.add(btnBoton1);
		btnBoton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="1";
				textId.setText(id);
			}
		});
		
		JButton btnBoton2 = new JButton("2");
		btnBoton2.setBounds(220, 125,59, 45);
		contentPane.add(btnBoton2);
		btnBoton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="2";
				textId.setText(id);
			}
		});
		
		JButton btnBoton3 = new JButton("3");
		btnBoton3.setBounds(278, 125, 59, 45);
		contentPane.add(btnBoton3);
		btnBoton3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="3";
				textId.setText(id);
			}
		});
		
		JButton btnBoton4 = new JButton("4");
		btnBoton4.setBounds(161, 170, 59, 45);
		contentPane.add(btnBoton4);
		btnBoton4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="4";
				textId.setText(id);
			}
		});
		
		JButton btnBoton5 = new JButton("5");
		btnBoton5.setBounds(220, 170, 59, 45);
		contentPane.add(btnBoton5);
		btnBoton5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="5";
				textId.setText(id);
			}
		});
		
		JButton btnBoton6 = new JButton("6");
		btnBoton6.setBounds(278, 170, 59, 45);
		contentPane.add(btnBoton6);
		btnBoton6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="6";
				textId.setText(id);
			}
		});
		
		JButton btnBoton7 = new JButton("7");
		btnBoton7.setBounds(161, 214, 59, 45);
		contentPane.add(btnBoton7);
		btnBoton7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="7";
				textId.setText(id);
			}
		});
		
		JButton btnBoton8 = new JButton("8");
		btnBoton8.setBounds(220, 214, 59, 45);
		contentPane.add(btnBoton8);
		btnBoton8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="8";
				textId.setText(id);
			}
		});
		
		JButton btnBoton9 = new JButton("9");
		btnBoton9.setBounds(278, 214, 59, 45);
		contentPane.add(btnBoton9);
		btnBoton9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				id+="9";
				textId.setText(id);
			}
		});
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AccesoLogin.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		lblLogo.setBounds(147, 11, 201, 55);
		contentPane.add(lblLogo);
		
		JButton btnFichar = new JButton("Fichar");
		btnFichar.setBounds(51, 320, 89, 23);
		contentPane.add(btnFichar);
		btnFichar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int respuesta = conexion.fichar(Integer.parseInt(textId.getText()));
				
				
				if (respuesta==1) {
					JOptionPane.showMessageDialog(null, "\n"
							+ "Fichaje realizado con exito", "Fichaje Realizado",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "\n"
							+ "Error al fichar", "Fichaje no realizado",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		setVisible(true);
	}
}
