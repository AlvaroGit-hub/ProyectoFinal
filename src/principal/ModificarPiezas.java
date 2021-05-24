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


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;


public class ModificarPiezas extends JFrame {

	private JPanel contentPane;
	private ConexionBBDD conexion;
	private JTextField textField;
	private ConexionBBDD conexion;
	private PreparedStatement ps;
	private ResultSet rs;

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

		JTextPane txtpnIdPieza = new JTextPane();
		txtpnIdPieza.setText("Nombre de la pieza a modificar");
		txtpnIdPieza.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnIdPieza.setEditable(false);
		txtpnIdPieza.setBackground(Color.GRAY);
		txtpnIdPieza.setBounds(104, 81, 189, 20);
		contentPane.add(txtpnIdPieza);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(292, 81, 86, 20);
		contentPane.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(10, 112, 528, 23);
		contentPane.add(separator);
		
		JTextPane txtNombre = new JTextPane();
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.GRAY);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(105, 137, 74, 20);
		contentPane.add(txtNombre);
		
		JTextPane txtPrecio = new JTextPane();
		txtPrecio.setEditable(false);
		txtPrecio.setText("Precio");
		txtPrecio.setBackground(Color.GRAY);
		txtPrecio.setBounds(105, 168, 74, 20);
		contentPane.add(txtPrecio);
		
		JTextPane txtDescripcion = new JTextPane();
		txtDescripcion.setEditable(false);
		txtDescripcion.setText("Descripci\u00F3n");
		txtDescripcion.setBackground(Color.GRAY);
		txtDescripcion.setBounds(105, 202, 74, 20);
		contentPane.add(txtDescripcion);
		
		JTextField textNombre = new JTextField();
		textNombre.setBounds(292, 137, 197, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JTextField textPrecio= new JTextField();
		textPrecio.setBounds(292, 168, 197, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JTextPane textDescripcion = new JTextPane();
		textDescripcion.setBounds(292, 202, 197, 77);
		contentPane.add(textDescripcion);
		//textDescripcion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(105, 300, 138, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
				
				String consulta="update pieza set";
				conexion.consultar("select nombre, precio, descripcion from pieza where nombre='"+textField.getText()+"'");
				String datos[][]=conexion.getDatos();
				
				if (!textNombre.getText().isEmpty()) {
					consulta+= "nombre='" + textNombre.getText()+"',";
				} else {
					consulta+= "nombre='" +datos[0][0]+"',";
				}
				if (!textPrecio.getText().isEmpty()) {
					consulta+= " apellidos='" + textPrecio.getText()+"',";
				}else {
					consulta+= "apellidos='" +datos[0][1]+"',";
				}
				if (!textDescripcion.getText().isEmpty()) {
					consulta+= "contrasena='" + textDescripcion.getText()+"',";
				}else {
					consulta+= "contrasena='" +datos[0][2]+"',";
				}
				
				consulta+="where id_empleado ="+textNombre.getText();
			
				ps = conexion.conectar().prepareStatement(consulta);
					
				ps.executeUpdate();
				
				dispose();
				JOptionPane.showMessageDialog(null, "\n"
						+ "Pieza modificada con exito", "Pieza modificada",
						JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "\n"
							+ "Datos erronesos, accion cancelada", "Usuario no modificado",
							JOptionPane.ERROR_MESSAGE);
					dispose();
				}
			}
			
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(292, 300, 138, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt3) {
				
				dispose();
				
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}

