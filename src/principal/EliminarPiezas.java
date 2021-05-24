package principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class EliminarPiezas extends JFrame {

	private JPanel contentPane;
	private ConexionBBDD conexion;
	private JTextField textNombre;
	private PreparedStatement ps;
	private ResultSet rs;


	public EliminarPiezas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EliminarPiezas.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		
		conexion=new ConexionBBDD();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width/2,pantalla.height/2);
		setTitle("Genti\u00F3n Empresarial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ModificarUsuario.class.getResource("/principal/gemlogotransdefinitivo1.png")));
		lblLogo.setBounds(164, 11, 237, 59);
		contentPane.add(lblLogo);
		
		textNombre = new JTextField();
		textNombre.setBounds(288, 170, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JTextPane txtNombrePieza = new JTextPane();
		txtNombrePieza.setEditable(false);
		txtNombrePieza.setBackground(Color.GRAY);
		txtNombrePieza.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNombrePieza.setText("Nombre de la pieza a eliminar");
		txtNombrePieza.setBounds(105, 170, 184, 20);
		contentPane.add(txtNombrePieza);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(105, 286, 138, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
					
					if (resp==0) {
						ps = conexion.conectar().prepareStatement("delete from empleado where id_empleado = ?");
						
						ps.setInt(1, Integer.parseInt(textNombre.getText()));
						
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
				
				
			}
			
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(292, 286, 138, 23);
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
