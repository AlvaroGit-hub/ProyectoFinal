package principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;

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
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(10, 147, 1031, 648);

		
		JLabel lblNewLabel = new JLabel("Hola mundo");
		lblNewLabel.setToolTipText("Hola mundo");
		lblNewLabel.setBounds(199, 219, 605, 234);
		panel_2.add(lblNewLabel);
		return panel_2;
	}
}
