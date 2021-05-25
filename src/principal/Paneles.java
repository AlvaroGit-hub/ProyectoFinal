package principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class Paneles {
	private ConexionBBDD bD;
	private JTable table;
	
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
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(983, 0, 17, 557);
		panel_2.add(scrollBar);
		

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
	
	
	
	public JPanel produccion() {
		

		bD= new ConexionBBDD();
				
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(973, 71, 17, 603);
		panel_2.add(scrollBar);

		

		
		
		JButton btnDiaria = new JButton("Diaria");
		btnDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bD.consultar("select pieza.id_pieza, pieza.nombre, descripcion, sum(cantidad_realizada) as cantidad from tarea inner join pieza where pieza.id_pieza = tarea.id_pieza group by pieza.id_pieza");
				
				JTable tabla = new JTable(bD.getDatos(),bD.getColumnas());
				tabla.setBackground(Color.WHITE);
				tabla.setBounds(10, 71, 980, 603);
				panel_2.add(tabla);
				panel_2.repaint();
				panel_2.revalidate();
			}
		});
		btnDiaria.setBounds(228, 11, 89, 23);
		panel_2.add(btnDiaria);
		
		JButton btnMensual = new JButton("Mensual");
		btnMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bD.consultar("select pieza.id_pieza, pieza.nombre, descripcion, sum(tarea.cantidad_realizada) as cantidad from tarea inner join pieza inner join realizar where pieza.id_pieza = tarea.id_pieza and datediff(curdate(),f_final) < 31 group by pieza.id_pieza");
				
				JTable tabla = new JTable(bD.getDatos(),bD.getColumnas());
				tabla.setBackground(Color.WHITE);
				tabla.setBounds(10, 71, 980, 603);
				panel_2.add(tabla);
				panel_2.repaint();
				panel_2.revalidate();
			}
		});
		btnMensual.setBounds(327, 11, 89, 23);
		panel_2.add(btnMensual);
		
		JButton btnAnual = new JButton("Anual");
		btnAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bD.consultar("select pieza.id_pieza, pieza.nombre, descripcion, sum(tarea.cantidad_realizada) as cantidad from tarea inner join pieza inner join realizar where pieza.id_pieza = tarea.id_pieza and datediff(curdate(),f_final) < 365 group by pieza.id_pieza");
				
				JTable tabla = new JTable(bD.getDatos(),bD.getColumnas());
				tabla.setBackground(Color.WHITE);
				tabla.setBounds(10, 71, 980, 603);
				panel_2.add(tabla);
				panel_2.repaint();
				panel_2.revalidate();
				
			}
		});
		btnAnual.setBounds(426, 11, 89, 23);
		panel_2.add(btnAnual);
		
		JButton btnTrabajador = new JButton("Por trabajador");
		btnTrabajador.setBounds(525, 11, 108, 23);
		panel_2.add(btnTrabajador);
		
		JTextField textTrabajador = new JTextField();
		textTrabajador.setBounds(643, 12, 108, 23);
		panel_2.add(textTrabajador);
		textTrabajador.setColumns(10);
		

		

		

		panel_2.setVisible(true);
		return panel_2;
	}
}
