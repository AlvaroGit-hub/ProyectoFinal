package principal;

import java.sql.*;
import java.util.Arrays;
import java.util.Iterator;

public class ConexionBBDD {
	
	private Connection con;
	private Statement smt;
	private ResultSet rs;
	private CallableStatement cls;
	private PreparedStatement ps;
	private String[] columnas;
	private String[][]datos;
	
	public void ConnexionBBDD() {
    	con=null;
    	smt=null;
    	rs=null;
    	cls=null;
    	columnas=null;
    	datos=null;
    }
    	
    public Connection conectar() {
    	/*
    	 * clase para realizar las conexiones a la base de datos
    	 */
    	
    	try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root","");	

            
        }catch(SQLException e) {
        	e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    	
    	return con;

    }
    

    public int login(String nombre, String contrasena) {
    	
    	int respuesta=0;
    	try {
			cls = conectar().prepareCall("{?=call login_usuario(?,?)}");
			cls.setString(2, nombre);
			cls.setString(3, contrasena);
			cls.registerOutParameter(1, java.sql.Types.INTEGER);
			cls.executeUpdate();
			respuesta=cls.getInt(1);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	
    	return respuesta;
    }
    
    public Statement getStatement() throws SQLException {
    	
			smt = conectar().createStatement();
	
    	return smt;
    }
    
   
    public void consultar(String consulta) {
		int posicion=0;
    	
    	try {
			
			rs = conectar().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(consulta);
			
			this.columnas= new String[rs.getMetaData().getColumnCount()];
			for(int i=0;i<this.columnas.length; i++) {
				this.columnas[i]= rs.getMetaData().getColumnName(i+1);
			}
			
			
			rs.last();
			this.datos=new String[rs.getRow()][rs.getMetaData().getColumnCount()];
			rs.beforeFirst();
			
			while (rs.next()) {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					this.datos[posicion][i]=rs.getString(i+1);
				}
				posicion++;
			}
			
		} catch (SQLException e) {
			System.out.println("Consulta Erronea");
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!rs.isClosed()) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
    }    
    
    
    public String[] getColumnas() {
		return columnas;
	}

	public String[][] getDatos() {
		return datos;
	}
    
    
    
	public void fichar(int id_usuario) {
		try {
			
			cls = conectar().prepareCall("{call insertar_fichaje(?)}");
			cls.setInt(1, id_usuario);
			cls.executeUpdate();
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void nuevaPieza(String nombrePieza,float precio,String descripcion) {
		try {
			cls = conectar().prepareCall("{call nueva_pieza(?,?,?)}");
			cls.setString(1, nombrePieza);
			cls.setFloat(2, precio);
			cls.setString(3, descripcion);
			cls.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int nuevoUsuario(String nombre,String apellidos,String contrasena,String categoria) {
		int respuesta=0;
		try {
			cls = conectar().prepareCall("{call nuevo_empleado(?,?,?,?)}");
			if (nombre.isEmpty() || apellidos.isEmpty() || contrasena.isEmpty()) {
				respuesta=0;
			}else {
				
				cls.setString(1, nombre);
				cls.setString(2, apellidos);
				cls.setString(3, contrasena);
				cls.setString(4, categoria);
				cls.executeUpdate();
				respuesta=1;
			}

			
		} catch (SQLException e) {
			System.out.println("Error en los datos introducidos");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return respuesta;
	}
	
	
	public void nuevoTarea(int idPieza, int cantidadDeseada) {
		try {
			cls = conectar().prepareCall("{call nueva_tarea(?,?)}");
			cls.setInt(1, idPieza);
			cls.setInt(2, cantidadDeseada);
			cls.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void iniciarTarea(int idTarea, int idEmpleado) {
		try {
			cls = conectar().prepareCall("{call iniciar_tarea(?,?)}");
			cls.setInt(1, idTarea);
			cls.setInt(2, idEmpleado);
			cls.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void finTarea(int idEmpleado, int cantidadRealizada) {
		try {
			cls = conectar().prepareCall("{call fin_tarea(?,?)}");
			cls.setInt(1, idEmpleado);
			cls.setInt(2, cantidadRealizada);
			cls.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conectar().isClosed()) {
					conectar().close();
				}
				if(!cls.isClosed()) {
					cls.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}