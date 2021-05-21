package principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class Login extends JFrame {
	
	private JPanel ventanaLogin;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private ConexionBBDD conexion;
	private Empleado emp;
	
	public Login() {
		
		conexion= new ConexionBBDD();
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		setTitle("Gesti\u00F3n Empresarial");
		setSize(pantalla.width/2,pantalla.height/2);
	    		
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ventanaLogin = new JPanel();
		
		
		setResizable(false);
		ventanaLogin.setBackground(Color.GRAY);
		ventanaLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(ventanaLogin);
		ventanaLogin.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(37, 92, 97, 42);
		ventanaLogin.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraseña.setBounds(37, 145, 97, 42);
		ventanaLogin.add(lblContraseña);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(158, 106, 232, 20);
		ventanaLogin.add(textUsuario);
		textUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 159, 232, 20);
		ventanaLogin.add(passwordField);
		passwordField.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {

					login();
				}
					
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Login.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		logo.setBounds(114, 11, 208, 66);
		ventanaLogin.add(logo);
		
		JButton btnNewButton = new JButton("Iniciar sesi\u00F3n");
		btnNewButton.setBounds(59, 213, 138, 23);
		ventanaLogin.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt) {
				
				login();
			}
		});
				
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(236, 213, 138, 23);
		ventanaLogin.add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				dispose();
				Registro r = new Registro();
				
			}			
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	
	public void login() {
		
		/*
		 * el metodo login se usa para llamar a un metodo de la clase conexion que a su vez ejecuta un procedimiento sql
		 * que lo que hace es comprobar que el usuario y la contraseña existen en la base de datos y que son correctos
		 * y nos devuelve 1 o 0 en funcion de si los datos son correctos o no. Luego llama a el metodo empleado para
		 * obtener los datos de usuario y nos abre la pantalla de la aplicacion.
		 */
				
		int res=conexion.login(textUsuario.getText(), passwordField.getText());
		
		if (res==1) {
			emp=empleado(textUsuario.getText(), passwordField.getText());
			System.out.println(emp.toString());
			Tablas t = new Tablas();
			dispose();
			System.out.println("conectado");
		}else {
			JOptionPane.showMessageDialog(null, "\n"
					+ "Usuario o contraseña incorrectas", "Acceso denegado",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	

	
	
	public Empleado empleado(String nombre, String contrasena) {
		
		/*
		 * Este metodo necesita que se le pasen por parametros un usuario u su contraseña, de esta forma
		 * obtiene de la base de datos todos los datos de el usuario para poder usarlos mas adelante
		 */
		
		Empleado empleado=new Empleado();
		try {
			ResultSet a= conexion.getStatement().executeQuery("Select * from empleado where nombre = '"+nombre+"' and contrasena = '"+contrasena+"'");
			
			while (a.next()) {
				empleado.setIdEmpleado(a.getInt(1));
				empleado.setNombre(a.getString(2));
				empleado.setApellido(a.getString(3));
				empleado.setContrasena(a.getString(4));
				try {
					empleado.setCategoria(a.getString(5));
				} catch (Exception e) {
					System.out.println("Categoria erronea en la base de datos");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en los datos");
		}

		
		return empleado;
	}
}
