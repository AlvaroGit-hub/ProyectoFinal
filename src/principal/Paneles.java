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
	public JPanel botonEmpleados() {
		

		bD= new ConexionBBDD();
		bD.consultar("select * from empleado");

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		
		JTable empleados = new JTable(bD.getDatos(),bD.getColumnas());
		empleados.setBounds(0, 0, 1000, 700);
		panel_2.add(empleados);
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
