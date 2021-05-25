
package principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class Registro extends JFrame {

	private JPanel ventanaNuevoUser;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JPasswordField contrasena;
	private ConexionBBDD conexion;
	private JComboBox cBCategoria;

	public Registro() {
		
		conexion=new ConexionBBDD();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width/2,pantalla.height/2);
		setTitle("Genti\u00F3n Empresarial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 376);
		ventanaNuevoUser = new JPanel();
		setResizable(false);
		
		ventanaNuevoUser.setBackground(Color.GRAY);
		ventanaNuevoUser.setForeground(Color.BLACK);
		ventanaNuevoUser.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(ventanaNuevoUser);
		ventanaNuevoUser.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(72, 109, 91, 14);
		ventanaNuevoUser.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(72, 132, 91, 30);
		ventanaNuevoUser.add(lblApellidos);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasena.setBounds(72, 164, 104, 28);
		ventanaNuevoUser.add(lblContrasena);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategoria.setBounds(72, 194, 91, 30);
		ventanaNuevoUser.add(lblCategoria);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Registro.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		lblLogo.setBounds(164, 11, 237, 59);
		ventanaNuevoUser.add(lblLogo);
			
		txtNombre = new JTextField();
		txtNombre.setBounds(210, 109, 264, 20);
		ventanaNuevoUser.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(210, 140, 264, 20);
		ventanaNuevoUser.add(txtApellidos);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(210, 171, 264, 20);
		ventanaNuevoUser.add(contrasena);
		
		cBCategoria = new JComboBox();
		cBCategoria.setModel(new DefaultComboBoxModel(new String[] {"Jefe", "Encargado", "Trabajador"}));
		cBCategoria.setBounds(210, 201, 264, 22);
		ventanaNuevoUser.add(cBCategoria);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(105, 286, 138, 23);
		ventanaNuevoUser.add(btnRegistro);
		btnRegistro.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent evt2) {
					int respuesta = conexion.nuevoUsuario(txtNombre.getText(),txtApellidos.getText(),contrasena.getText(),String.valueOf(cBCategoria.getSelectedItem()));
					
					if (respuesta==1) {
						dispose();
						JOptionPane.showMessageDialog(null, "\n"
								+ "Nuevo usuario creado con exito", "Usuario creado",
								JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						dispose();
						JOptionPane.showMessageDialog(null, "\n"
								+ "Datos erronesos, accion cancelada", "Usuario no creado",
								JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(292, 286, 138, 23);
		ventanaNuevoUser.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt3) {
				
				dispose();	
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}

}

