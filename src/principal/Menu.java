package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class Menu extends JFrame{

	private JPanel contentPane;
	
	
	public Menu() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\ProyectoFinal\\src\\principal\\gemlogotransdefinitivo1.png"));
		setTitle("Gesti\u00F3n Empresarial");
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(13, 11, 607, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.GRAY);
//		panel_1.setBounds(13, 59, 587, 235);
//		panel.add(panel_1);
//		panel_1.setLayout(new GridLayout(0, 2, 10, 5));
//		
//		JButton btnInformacionUsuario = new JButton("Informaci\u00F3n usuario");
//		panel_1.add(btnInformacionUsuario);
//		btnInformacionUsuario.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent evt) {
//				dispose();
//				
//			}
//			
//		});
//		
//		JButton btnInformacionStock = new JButton("Informaci\u00F3n stock");
//		panel_1.add(btnInformacionStock);
//		btnInformacionStock.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent evt) {
//				dispose();
//				
//			}
//			
//		});
//		
//		JButton btnInformacionProduccion = new JButton("Informaci\u00F3n producci\u00F3n");
//		btnInformacionProduccion.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//				
//			}
//		});
//		panel_1.add(btnInformacionProduccion);
//		
//		JButton btnInformacionTareas = new JButton("Informaci\u00F3n tareas");
//		panel_1.add(btnInformacionTareas);
//		btnInformacionTareas.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//				
//			}
//		});
//		
//		JButton btnRegistrarUsuario = new JButton("Registrar nuevo usuario");
//		panel_1.add(btnRegistrarUsuario);
//		btnRegistrarUsuario.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//				
//			}
//		});
//		
//		JButton btnAsignarTarea = new JButton("Asignar nueva tarea");
//		panel_1.add(btnAsignarTarea);
//		btnAsignarTarea.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//				
//			}
//			
//		});
		
		JLabel lblUser = new JLabel("Usuario :");
		lblUser.setBounds(382, 11, 75, 14);
		panel.add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(221, 322, 171, 23);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent evt) {
				dispose();
				Login l=new Login();
			}
			
		});
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(26, 0, 75, 42);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		
		JLabel lblNombreUsuario = new JLabel("");
		lblNombreUsuario.setBounds(466, 14, 75, 14);
		panel.add(lblNombreUsuario);
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 587, 235);
		panel.add(panel_2);
		
		JButton btnTareasAsignadas = new JButton("Tareas asignadas");
		btnTareasAsignadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.setLayout(new GridLayout(0, 2, 10, 5));
		panel_2.add(btnTareasAsignadas);
		
		JButton btnTareasRealizadas = new JButton("Tareas realizadas");
		panel_2.add(btnTareasRealizadas);
		
		JButton btnProduccionUsuario = new JButton("Producci\u00F3n usuario");
		panel_2.add(btnProduccionUsuario);
		
		JButton btnJornadaUsuario = new JButton("Jornada usuario");
		panel_2.add(btnJornadaUsuario);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JButton btnAdministrarCuenta = new JButton("Administrar cuenta");
		panel_2.add(btnAdministrarCuenta);
		setVisible(true);
	
		//panel_1.setVisible(true);
	}
}
