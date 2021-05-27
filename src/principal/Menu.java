
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
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import java.awt.CardLayout;

public class Menu extends JFrame{

	private JPanel contentPane;
	private Paneles paneles;
	
	
	public Menu(Empleado empleado) {
		
		paneles=new Paneles();

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width/2,pantalla.height/2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		setTitle("Gesti\u00F3n Empresarial");
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1061, 920);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(13, 11, 1051, 806);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario :");
		lblUser.setBounds(397, 43, 75, 14);
		panel.add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(26, 29, 75, 45);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/principal/gemlogotransdefinitivopeque\u00F1o.png")));
		
		JLabel lblNombreUsuario = new JLabel(empleado.getNombre());
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreUsuario.setBounds(484, 36, 75, 31);
		panel.add(lblNombreUsuario);
	
		
		JPanel contenido = new JPanel();
		contenido.setBackground(Color.GRAY);
		contenido.setBounds(10, 147, 1031, 648);
		panel.add(contenido);
		contenido.setLayout(new CardLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.setBorderPainted(false);
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar.setBackground(Color.GRAY);
		menuBar.setForeground(Color.GRAY);
		menuBar.setBounds(258, 78, 732, 30);
		panel.add(menuBar);
		
		JButton btnEmpelados = new JButton("Mostrar Empleados");
		btnEmpelados.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEmpelados.setMargin(new Insets(14, 14, 14, 14));
		menuBar.add(btnEmpelados);
		btnEmpelados.addActionListener(new ActionListener() {
			

				public void actionPerformed(ActionEvent evt) {
					contenido.removeAll();
					contenido.add(paneles.botonEmpleados());
					contenido.repaint();
					contenido.revalidate();
				}		
		});
		
		JButton btnPiezas = new JButton("  Mostrar piezas  ");
		btnPiezas.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPiezas.setMargin(new Insets(14, 14, 14, 14));
		menuBar.add(btnPiezas);
		btnPiezas.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent evt) {
					contenido.removeAll();
					contenido.add(paneles.botonPiezas());
					contenido.repaint();
					contenido.revalidate();
					
				}
			
		});
		
		JButton btnProduccion= new JButton("Producci\u00F3n usuario");
		btnProduccion.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnProduccion.setMargin(new Insets(14, 14, 14, 14));
		menuBar.add(btnProduccion);
		btnProduccion.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent evt) {
					contenido.removeAll();
					contenido.add(paneles.produccion());
					contenido.repaint();
					contenido.revalidate();
				}
			
		});
		
		JButton btnSalir_1 = new JButton("Salir");
		btnSalir_1.setMargin(new Insets(14, 14, 14, 14));
		btnSalir_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuBar.add(btnSalir_1);

		btnSalir_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
}

