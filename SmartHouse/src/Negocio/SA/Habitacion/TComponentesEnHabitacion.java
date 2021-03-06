package Negocio.SA.Habitacion;

public class TComponentesEnHabitacion {

	private int IDComponente;
	private int IDhabitacion;
	private String nombre;
	private int dato;
	private String tipo;//se encuentra en tabla compontentes
	private String ip;
	private String contrasena;
	
	public TComponentesEnHabitacion( int idComp, int hab, String nombre, int dato)
	{
		IDComponente = idComp;
		this.nombre = nombre;
		this.dato = dato;
		this.IDhabitacion = hab;
	}
	
	public TComponentesEnHabitacion() {}

	public int getIDComponente() {
		return IDComponente;
	}
	public void setIDComponente(int iDComponente) {
		IDComponente = iDComponente;
	}
	public int getIDhabitacion() {
		return IDhabitacion;
	}
	public void setIDhabitacion(int iDhabitacion) {
		IDhabitacion = iDhabitacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
