package principal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.mysql.cj.xdevapi.Statement;


public class PruebasJorge {

	public static void main(String[] args) {
		ConexionBBDD conexion = new ConexionBBDD();
		
		
		//conexion.nuevaPieza("Pieza de prueba", 10.3f, "Descripcion de prueba");
		
		

//		String resutado[][]=conexion.consultar("Select * from empleado");
		
//		for (int i = 0; i < resutado.length; i++) {
//			System.out.println(Arrays.toString(resutado[i]));
//		}
		
		int res = conexion.login("Alvaro", "qwerty");
	
//		System.out.println(res);

//		String resutado[][]=conexion.consultar("Select * from empleado where nombre = 'jorge'");
//		
//		for (int i = 0; i < resutado.length; i++) {
//			System.out.println(Arrays.toString(resutado[i]));
		
		
		

		
		
	

	}

}
