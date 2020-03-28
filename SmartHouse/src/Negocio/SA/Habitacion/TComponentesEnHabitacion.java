package Negocio.SA.Habitacion;

public class TComponentesEnHabitacion {

	private int IDComponente;
	private int IDhabitacion;
	private String nombre;
	private int dato;
	
	
	public TComponentesEnHabitacion( int idComp, int hab, String nombre, int dato)
	{
		IDComponente = idComp;
		this.nombre = nombre;
		this.dato = dato;
		this.IDhabitacion = hab;
	}
	
	public TComponentesEnHabitacion() {
		// TODO Auto-generated constructor stub
	}

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
	
}
