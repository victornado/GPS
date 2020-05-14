package Negocio.SA.Habitacion;

import java.util.List;

public class THabitacion {

	private int ID;
	private int IDCasa;
	private String tipo;
	private String nombre;
	private List<TComponentesEnHabitacion> componentes;
	
	public THabitacion(int id, int idCasa, String tipo2, String nombre2) {
		ID = id;
		IDCasa = idCasa;
		tipo = tipo2;
		nombre = nombre2;
	}
	
	public THabitacion() {}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getIDCasa() {
		return IDCasa;
	}
	public void setIDCasa(int iDCasa) {
		IDCasa = iDCasa;
	}
	public String getTipo() {
		return tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<TComponentesEnHabitacion> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<TComponentesEnHabitacion> componentes) {
		this.componentes = componentes;
	}
	
	
}
