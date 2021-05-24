package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RegistroPiezas extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextPane textDescripcion;
	private ConexionBBDD conexion;

	public RegistroPiezas() {
		conexion=new ConexionBBDD();
		setTitle("Gesti\u00F3n Empresarial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombrePieza = new JLabel("Nombre");
		lblNombrePieza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombrePieza.setBounds(49, 56, 83, 14);
		contentPane.add(lblNombrePieza);
		
		JLabel lblPrecioPieza = new JLabel("Precio");
		lblPrecioPieza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecioPieza.setBounds(49, 98, 83, 14);
		contentPane.add(lblPrecioPieza);
		
		JLabel lblDescripcionPieza = new JLabel("Descripci\u00F3n");
		lblDescripcionPieza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcionPieza.setBounds(49, 134, 101, 30);
		contentPane.add(lblDescripcionPieza);
		
		textNombre = new JTextField();
		textNombre.setBounds(160, 53, 264, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(160, 95, 264, 20);
		contentPane.add(textPrecio);
		
		textDescripcion = new JTextPane();
		//textDescripcion.setColumns(10);
		textDescripcion.setBounds(160, 143, 264, 69);
		contentPane.add(textDescripcion);
		
		JButton btnRegistro = new JButton("Registrar pieza");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistro.setBounds(60, 245, 140, 23);
		contentPane.add(btnRegistro);
		btnRegistro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				conexion.nuevaPieza(textNombre.getName(),Float.parseFloat(textPrecio.getText()),textDescripcion.getText());
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(251, 245, 140, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu m=new Menu();
				
			}
		});
	}
}
