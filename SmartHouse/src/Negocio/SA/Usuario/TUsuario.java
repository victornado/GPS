package Negocio.SA.Usuario;

public class TUsuario {
	private int ID;
	private int IDCasa;
	private String correo;
	private String tipo;
	private String contrasena;
	private int edad;
	private String nombre;
	private String apellidos;
	
	public TUsuario (String Nom, String Contr){
		nombre=Nom;
		contrasena=Contr;
	}
	public TUsuario(String Nom,String Contr,String tipo) {
		nombre=Nom;
		contrasena=Contr;
		this.tipo=tipo;
	}

	public TUsuario() {
		
		ID = 0;
		IDCasa = 0;
		correo = null;
		tipo = null;
		contrasena = null;
		edad = 0;
		nombre = null;
		apellidos = null;
	}


	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getIDCasa() {
		return IDCasa;
	}

	public void setIDCasa(Integer iDCasa) {
		IDCasa = iDCasa;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
