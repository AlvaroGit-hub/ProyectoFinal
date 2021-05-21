package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCategoria;
	private JPasswordField contraseña;


	public Registro() {
		
		this.setResizable(false);
		
		setTitle("Genti\u00F3n Empresarial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/interfaz/gemlogotransdefinitivo1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(73, 99, 91, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(73, 134, 91, 30);
		contentPane.add(lblApellidos);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraseña.setBounds(73, 186, 104, 28);
		contentPane.add(lblContraseña);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategoria.setBounds(73, 229, 91, 30);
		contentPane.add(lblCategoria);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Registro.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		lblLogo.setBounds(164, 11, 237, 59);
		contentPane.add(lblLogo);
			
		txtNombre = new JTextField();
		txtNombre.setBounds(211, 96, 264, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(211, 142, 264, 20);
		contentPane.add(txtApellidos);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(211, 193, 264, 20);
		contentPane.add(contraseña);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(211, 237, 264, 20);
		contentPane.add(txtCategoria);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(105, 286, 138, 23);
		contentPane.add(btnRegistro);
		btnRegistro.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent evt2) {
				
					String Nombre = txtNombre.getText();
					String Apellidos = txtApellidos.getText();
					String Contraseña = contraseña.getText();
					String Categoria = txtCategoria.getText();
					
					
					String bd="empresa";
					String url ="jdbc:mysql://localhost:3306/" + bd;
					
					String usuario = "root";
					String password = null;

					java.sql.Connection conn= null;
					
					java.sql.Statement stmt = null;
					
					ResultSet rs = null;
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						conn=DriverManager.getConnection(url, usuario, password);
						
						stmt= conn.createStatement();
						
						if(!Nombre.equals("") && !Apellidos.equals("") && !Contraseña.equals("") && !Categoria.equals("")) {
							
							//PROCEDURE
						
//							if(Nombre.equals(nombre) && Apellidos.equals(apellidos)) {
//								System.out.println("Registro fallido");
//								 
//				                 JOptionPane.showMessageDialog(null, "\n"
//				                		 + "Usuario ya existente",   "Fallo al registrarse",
//				                		 JOptionPane.ERROR_MESSAGE);
//							}else {
//								System.out.println("Registro exitoso");
//							 
//								JOptionPane.showMessageDialog(null, "\n"
//										+ "Se ha registrado correctamente en el sistema", "Registro exitoso",
//										JOptionPane.INFORMATION_MESSAGE);
//							}
						}else {
							JOptionPane.showMessageDialog(null, "\n"
									+ "Ingresa correctamente los datos", "Registro fallido",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(292, 286, 138, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt3) {
				
				dispose();
				Login i = new Login();	
			}
		});
		
		
		setVisible(true);
	}
}
