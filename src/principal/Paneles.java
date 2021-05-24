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
//	public JPanel botonEmpleados() {
//		
//
//		bD= new ConexionBBDD();
//		bD.consultar("select * from empleado");
//
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(Color.GRAY);
//		panel_2.setBounds(13, 59, 1000, 700);
//		panel_2.setLayout(null);
//		
//		JTable tabla = new JTable(bD.getDatos(),bD.getColumnas());
//		tabla.setBounds(0, 0, 1000, 557);
//		panel_2.add(tabla);
//
//		panel_2.setVisible(true);
//		return panel_2;
//	}
	public JPanel botonPiezas() {
		

		bD= new ConexionBBDD();
		bD.consultar("select * from pieza");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		JTable  tabla= new JTable(bD.getDatos(),bD.getColumnas());
		tabla.setBounds(0, 0, 1000, 557);
		panel_2.add(tabla);
	
        JButton btnNuevaPieza = new JButton("Nueva pieza");
        btnNuevaPieza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	RegistroPiezas rp=new RegistroPiezas();
            	rp.setVisible(true);
            }
        });
        btnNuevaPieza.setBounds(190, 613, 114, 23);
        panel_2.add(btnNuevaPieza);

        JButton btnModificarPieza = new JButton("Modificar pieza");
        btnModificarPieza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
        });
        btnModificarPieza.setBounds(437, 613, 120, 23);
        panel_2.add(btnModificarPieza);

        JButton btnEliminarPieza = new JButton("Eliminar pieza");
        btnEliminarPieza.setBounds(686, 613, 114, 23);
        panel_2.add(btnEliminarPieza);
        btnEliminarPieza.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent arg0) {
				
			}
        	
        });
		
		panel_2.setVisible(true);
		
		return panel_2;
	}
	public JPanel botonProduccionUsuario(int id) {
		

		bD= new ConexionBBDD();
		bD.consultar("select id_tarea,cantidad_realizada, timediff(time (f_final),time (f_inicio)) from realizar  where id_empleado='"+id+"'");

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		

		JTable produccion = new JTable(bD.getDatos(),bD.getColumnas());
		produccion.setBounds(0, 0, 1000, 700);
		panel_2.add(produccion);
		panel_2.setVisible(true);
		return panel_2;
	}
	public JPanel botonTareas() {
		

		bD= new ConexionBBDD();
		bD.consultar("select * from tareas");

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		
		JTable tareas = new JTable(bD.getDatos(),bD.getColumnas());
		tareas.setBounds(0, 0, 1000, 700);
		panel_2.add(tareas);
		panel_2.setVisible(true);
		return panel_2;
	}
	
	public JPanel pruebas() {

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
