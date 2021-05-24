package principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

public class Paneles {
	private ConexionBBDD bD;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel botonEmpleados() {
		

		bD= new ConexionBBDD();
		bD.consultar("select * from empleado");

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		
		System.out.println(Arrays.toString(bD.getColumnas()));
		JTable tabla = new JTable(bD.getDatos(),bD.getColumnas());
		tabla.setBounds(0, 0, 1000, 557);
		panel_2.add(tabla);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro r = new Registro();
			}
		});
		btnNuevo.setBounds(356, 613, 89, 23);
		panel_2.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuario u = new ModificarUsuario();
			}
		});
		btnModificar.setBounds(455, 613, 89, 23);
		panel_2.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarUsuario u=new EliminarUsuario();
				
			}
		});
		btnEliminar.setBounds(554, 613, 89, 23);
		panel_2.add(btnEliminar);
		panel_2.setVisible(true);
		return panel_2;
	}
public JPanel botonPiezas() {
		

		bD= new ConexionBBDD();
		bD.consultar("select * from piezas");

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		
		System.out.println(Arrays.toString(bD.getColumnas()));
		JTable tabla = new JTable(bD.getDatos(),bD.getColumnas());
		tabla.setBounds(0, 0, 1000, 557);
		panel_2.add(tabla);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroPiezas rp = new RegistroPiezas();
			}
		});
		btnNuevo.setBounds(356, 613, 89, 23);
		panel_2.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarPiezas mp = new ModificarPiezas();
			}
		});
		btnModificar.setBounds(455, 613, 89, 23);
		panel_2.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPiezas ep=new EliminarPiezas();
				
			}
		});
		btnEliminar.setBounds(554, 613, 89, 23);
		panel_2.add(btnEliminar);
		panel_2.setVisible(true);
		return panel_2;
	}
	
	
	

}
