package principal;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class ModificarUsuario extends JFrame {

	private JPanel ventanaNuevoUser;
	private ConexionBBDD conexion;
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textContraseña;
	private JComboBox cBCategoria;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public ModificarUsuario() {
		
		conexion=new ConexionBBDD();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width/2,pantalla.height/2);
		setTitle("Genti\u00F3n Empresarial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarUsuario.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 376);
		ventanaNuevoUser = new JPanel();
		setResizable(false);
		
		ventanaNuevoUser.setBackground(Color.GRAY);
		ventanaNuevoUser.setForeground(Color.BLACK);
		ventanaNuevoUser.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(ventanaNuevoUser);
		ventanaNuevoUser.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		lblLogo.setBounds(164, 11, 237, 59);
		ventanaNuevoUser.add(lblLogo);
		
		textID = new JTextField();
		textID.setBounds(292, 81, 86, 20);
		ventanaNuevoUser.add(textID);
		textID.setColumns(10);
		
		JTextPane txtpnIdDeEmpleado = new JTextPane();
		txtpnIdDeEmpleado.setEditable(false);
		txtpnIdDeEmpleado.setBackground(Color.GRAY);
		txtpnIdDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnIdDeEmpleado.setText("Id de empleado a modificar");
		txtpnIdDeEmpleado.setBounds(109, 81, 161, 20);
		ventanaNuevoUser.add(txtpnIdDeEmpleado);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setEditable(false);
		txtpnNombre.setBackground(Color.GRAY);
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(105, 137, 74, 20);
		ventanaNuevoUser.add(txtpnNombre);
		
		JTextPane txtApellidos = new JTextPane();
		txtApellidos.setEditable(false);
		txtApellidos.setText("Apellidos");
		txtApellidos.setBackground(Color.GRAY);
		txtApellidos.setBounds(105, 168, 74, 20);
		ventanaNuevoUser.add(txtApellidos);
		
		JTextPane txtContraseña = new JTextPane();
		txtContraseña.setEditable(false);
		txtContraseña.setText("Contrase\u00F1a");
		txtContraseña.setBackground(Color.GRAY);
		txtContraseña.setBounds(105, 202, 74, 20);
		ventanaNuevoUser.add(txtContraseña);
		
		JTextPane txtCategoria = new JTextPane();
		txtCategoria.setEditable(false);
		txtCategoria.setText("Categoria");
		txtCategoria.setBackground(Color.GRAY);
		txtCategoria.setBounds(105, 233, 74, 20);
		ventanaNuevoUser.add(txtCategoria);
		
		textNombre = new JTextField();
		textNombre.setBounds(292, 137, 86, 20);
		ventanaNuevoUser.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(292, 168, 86, 20);
		ventanaNuevoUser.add(textApellidos);
		textApellidos.setColumns(10);
		
		textContraseña = new JTextField();
		textContraseña.setBounds(292, 202, 86, 20);
		ventanaNuevoUser.add(textContraseña);
		textContraseña.setColumns(10);
		
		cBCategoria = new JComboBox();
		cBCategoria.setModel(new DefaultComboBoxModel(new String[] {"Jefe", "Encargado", "Trabajador"}));
		cBCategoria.setBounds(292, 233, 86, 22);
		ventanaNuevoUser.add(cBCategoria);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(10, 112, 528, 23);
		ventanaNuevoUser.add(separator);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(105, 286, 138, 23);
		ventanaNuevoUser.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent evt2) {
					/*
					 * Consulta de update dinamica para que en el caso de que un campo no sea rellenado por el usuario conseve
					 * el que tiene por defecto.
					 * 
					 */
					try {
						
						String consulta="update empleado set ";
						conexion.consultar("select nombre, apellidos, contrasena, categoria from empleado where id_empleado="+textID.getText());
						String datos[][]=conexion.getDatos();
						
						
						
						if (!textNombre.getText().isEmpty()) {
							consulta+= "nombre='" + textNombre.getText()+"',";
						} else {
							consulta+= "nombre='" +datos[0][0]+"',";
						}
						
						if (!textApellidos.getText().isEmpty()) {
							consulta+= " apellidos='" + textApellidos.getText()+"',";
						}else {
							consulta+= "apellidos='" +datos[0][1]+"',";
						}
						
						if (!textContraseña.getText().isEmpty()) {
							consulta+= "contrasena='" + textContraseña.getText()+"',";
						}else {
							consulta+= "contrasena='" +datos[0][2]+"',";
						}
						
						if (!textContraseña.getText().isEmpty()) {
							consulta+= "categoria='" + String.valueOf(cBCategoria.getSelectedItem())+"'";
						}else {
							consulta+= "categoria='" +datos[0][3]+"'";
						}
						
						consulta+="where id_empleado ="+textID.getText();
						
						
						ps = conexion.conectar().prepareStatement(consulta);
						
						
						ps.executeUpdate();
						
						dispose();
						JOptionPane.showMessageDialog(null, "\n"
								+ "Usuario modificado con exito", "Usuario modificado",
								JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "\n"
								+ "Datos erronesos, accion cancelada", "Usuario no modificado",
								JOptionPane.ERROR_MESSAGE);
						dispose();
					}catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "\n"
								+ "Datos erronesos, accion cancelada", "Usuario no modificado",
								JOptionPane.ERROR_MESSAGE);
						dispose();
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