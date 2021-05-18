package Principal;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		String usuario="root", pass="";
		Statement st=null;
		ResultSet rs=null;
		BufferedWriter bw=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			st= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas1", usuario, pass).createStatement();
			
			//insertar campo
			//st.executeUpdate("insert into productos values('mandarina','fresquisima',2.3)");
			//modificar campo
			//st.executeUpdate("update productos set descripcion = 'de hoy' where nombre='mandarina'");
			//eliminar campo
			//st.executeUpdate("delete from productos where nombre ='platano'");
			
			login(st,rs);
			
//			rs=st.executeQuery("select * from productos");
//			
//			bw=new BufferedWriter(new FileWriter("copiaseg.csv"));
//			bw.write("Nombre;Descripcion;Precio");
//			bw.newLine();
//			
//			while(rs.next()) {
//				bw.write(rs.getString("nombre")+";"+rs.getString("descripcion")+";"+rs.getFloat("precio"));
//				bw.newLine();
//				System.out.println(rs.getString("nombre")+" "+rs.getFloat("precio")+" €");
//			
//			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException d) {
		        	d.printStackTrace();;
		        }
		    }
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException d) {
		        	d.printStackTrace();;
		        }
		    }
		}
	}
	
	public static void login(Statement st, ResultSet rs) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Inserte en nombre de usuario");
		String nombre = sc.next();
		System.out.println("Inserte la contraseña");
		String contrasena=sc.next();
		
		try {
			rs=st.executeQuery("Select nombre, contraseña from usuarios where nombre = '"+nombre+"'");
			
			if (rs.next()) {
				if (rs.getString("contraseña").equals(contrasena)) {
					System.out.println("Bienvenido "+ nombre);
				}else {
					System.out.println("Contraseña incorrecta");
				}
			}else {
				System.out.println("Usuario no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
