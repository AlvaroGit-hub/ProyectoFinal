package principal;

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String categoria;
	
	public Empleado() {
		idEmpleado=0;
		nombre=null;
		apellido=null;
		contrasena=null;
		categoria=null;
	}
	
	public Empleado(int id,String nombre,String apellido,String contrasena,String categoria) {
		this.idEmpleado=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.contrasena=contrasena;
		try {
			setCategoria(categoria);
		} catch (Exception e) {
			System.out.println("Categoria erronea");
		}
	}
	
	public String toString() {
		return "Nombre: "+nombre+" Apellidos: "+apellido+" Categoria: "+categoria;
	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) throws Exception {
		
		if (categoria.equalsIgnoreCase("jefe")||categoria.equalsIgnoreCase("encargado")||categoria.equalsIgnoreCase("trabajador")) {
			this.categoria = categoria;
		}else {
			throw new Exception();
		}
		
	}

}
