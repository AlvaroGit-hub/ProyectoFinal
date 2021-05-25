
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
	private JPanel panel_2;

	
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
		

		JTable tabla = new JTable(bD.getDatos(),bD.getColumnas()){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                    return false;
            };
        };
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
		bD.consultar("select * from pieza");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);
		JTable  tabla= new JTable(bD.getDatos(),bD.getColumnas()){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
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
            	
            	ModificarPiezas mp=new ModificarPiezas();
            	mp.setVisible(true);
            }
        });
        btnModificarPieza.setBounds(437, 613, 120, 23);
        panel_2.add(btnModificarPieza);

        JButton btnEliminarPieza = new JButton("Eliminar pieza");
        btnEliminarPieza.setBounds(686, 613, 114, 23);
        panel_2.add(btnEliminarPieza);
        btnEliminarPieza.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent arg0) {
				
				EliminarPiezas ep=new EliminarPiezas();
				ep.setVisible(true);
			}
        	
        });
		
		panel_2.setVisible(true);
		
		return panel_2;
	}
  
  
		public JPanel produccion() {
		

		bD= new ConexionBBDD();
				
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(13, 59, 1000, 700);
		panel_2.setLayout(null);

		JPanel tablas = new JPanel();
		tablas.setBounds(0, 45, 1000, 655);
		panel_2.add(tablas);
		tablas.setLayout(null);

		JTextField textTrabajador = new JTextField();
		textTrabajador.setBounds(643, 12, 108, 23);
		panel_2.add(textTrabajador);
		textTrabajador.setColumns(10);
		
		JButton btnDiaria = new JButton("Diaria");
		btnDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bD.consultar("select tarea.id_pieza, pieza.nombre, pieza.descripcion, sum(tarea.cantidad_realizada) from tarea left join pieza on tarea.id_pieza = pieza.id_pieza left join realizar on tarea.id_tarea = realizar.id_tarea where datediff(curdate(),f_final) < 1 group by tarea.id_pieza");
				
				tablas.removeAll();
				
				table = new JTable(bD.getDatos(),bD.getColumnas()){
		            private static final long serialVersionUID = 1L;

		            public boolean isCellEditable(int row, int column) {
		                    return false;
		            };
		        };
				table.setBackground(Color.WHITE);
				table.setBounds(10, 71, 980, 603);
				table.repaint();
				table.revalidate();
				


				tablas.add(table);
				tablas.repaint();
				tablas.revalidate();
			}
		});
		btnDiaria.setBounds(228, 11, 89, 23);
		panel_2.add(btnDiaria);
		
		JButton btnMensual = new JButton("Mensual");
		btnMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bD.consultar("select tarea.id_pieza, pieza.nombre, pieza.descripcion, sum(tarea.cantidad_realizada) from tarea left join pieza on tarea.id_pieza = pieza.id_pieza left join realizar on tarea.id_tarea = realizar.id_tarea where datediff(curdate(),f_final) < 30 group by tarea.id_pieza");
				
				tablas.removeAll();
				
				table = new JTable(bD.getDatos(),bD.getColumnas()){
		            private static final long serialVersionUID = 1L;

		            public boolean isCellEditable(int row, int column) {
		                    return false;
		            };
		        };
				table.setBackground(Color.WHITE);
				table.setBounds(10, 71, 980, 603);
				table.repaint();
				
				tablas.add(table);
				tablas.repaint();
				tablas.revalidate();
				
			}
		});
		btnMensual.setBounds(327, 11, 89, 23);
		panel_2.add(btnMensual);
		
		JButton btnAnual = new JButton("Anual");
		btnAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bD.consultar("select tarea.id_pieza, pieza.nombre, pieza.descripcion, sum(tarea.cantidad_realizada) from tarea left join pieza on tarea.id_pieza = pieza.id_pieza left join realizar on tarea.id_tarea = realizar.id_tarea where datediff(curdate(),f_final) < 365 group by tarea.id_pieza");
				
				tablas.removeAll();
				
				table = new JTable(bD.getDatos(),bD.getColumnas()){
		            private static final long serialVersionUID = 1L;

		            public boolean isCellEditable(int row, int column) {
		                    return false;
		            };
		        };
				table.setBackground(Color.WHITE);
				table.setBounds(10, 71, 980, 603);
				table.repaint();
				
				tablas.add(table);
				tablas.repaint();
				tablas.revalidate();
				
			}
		});
		btnAnual.setBounds(426, 11, 89, 23);
		panel_2.add(btnAnual);
		
		JButton btnTrabajador = new JButton("Por trabajador");
		btnTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id="";
				if (textTrabajador.getText().isEmpty()) {
					id="0";
				}else {
					id=textTrabajador.getText();
				}
				bD.consultar("select tarea.id_pieza, pieza.nombre, pieza.descripcion, sum(tarea.cantidad_realizada) from tarea left join pieza on tarea.id_pieza = pieza.id_pieza left join realizar on tarea.id_tarea = realizar.id_tarea where realizar.id_empleado = " + id +" group by tarea.id_pieza");
				
				tablas.removeAll();
				
				table = new JTable(bD.getDatos(),bD.getColumnas()){
		            private static final long serialVersionUID = 1L;

		            public boolean isCellEditable(int row, int column) {
		                    return false;
		            };
		        };
				table.setBackground(Color.WHITE);
				table.setBounds(10, 71, 980, 603);
				table.repaint();
				
				tablas.add(table);
				tablas.repaint();
				tablas.revalidate();
			}
		});
		btnTrabajador.setBounds(525, 11, 108, 23);
		panel_2.add(btnTrabajador);
		
	
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(983, 0, 17, 644);
		tablas.add(scrollBar);
		
		
		panel_2.setVisible(true);
		return panel_2;
	}
}
