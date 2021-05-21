package principal;

import java.util.Arrays;


public class PruebasJorge {

	public static void main(String[] args) {
		ConexionBBDD conexion = new ConexionBBDD();
		
		//conexion.nuevaPieza("Pieza de prueba", 10.3f, "Descripcion de prueba");
		
		
		String resutado[][]=conexion.consultar("Select * from empleado where nombre = 'jorge'");
		
		for (int i = 0; i < resutado.length; i++) {
			System.out.println(Arrays.toString(resutado[i]));
		}
	
	}

}
