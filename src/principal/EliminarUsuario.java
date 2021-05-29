
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




public class EliminarUsuario extends JFrame {

	private JPanel ventanaNuevoUser;
	private ConexionBBDD conexion;
	private JTextField textID;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public EliminarUsuario() {
		
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
		textID.setBounds(288, 170, 86, 20);
		ventanaNuevoUser.add(textID);
		textID.setColumns(10);
		
		JTextPane txtpnIdDeEmpleado = new JTextPane();
		txtpnIdDeEmpleado.setEditable(false);
		txtpnIdDeEmpleado.setBackground(Color.GRAY);
		txtpnIdDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnIdDeEmpleado.setText("Id de empleado a eliminar");
		txtpnIdDeEmpleado.setBounds(105, 170, 161, 20);
		ventanaNuevoUser.add(txtpnIdDeEmpleado);
		
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
						int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
						
						if (resp==0) {
							ps = conexion.conectar().prepareStatement("delete from empleado where id_empleado = ?");
							
							ps.setInt(1, Integer.parseInt(textID.getText()));
							
							ps.executeUpdate();
							dispose();
							JOptionPane.showMessageDialog(null, "\n"
									+ "Usuario eliminado exito", "Usuario modificado",
									JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							dispose();
							JOptionPane.showMessageDialog(null, "\n"
									+ "Accion cancelada", "Usuario no eliminado",
									JOptionPane.ERROR_MESSAGE);
						}
						

						
						
						

						
					} 
					catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "\n"
								+ "Datos erronesos, accion cancelada", "Usuario no eliminado",
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