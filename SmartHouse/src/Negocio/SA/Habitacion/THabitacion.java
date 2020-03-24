package Negocio.SA.Habitacion;

import java.util.List;

public class THabitacion {

	private int ID;
	private int IDCasa;
	private String tipo;
	private List<TComponentesEnHabitacion> componentes;
	
	public THabitacion(int id, int idCasa, String tipo2) {
		ID = id;
		IDCasa = idCasa;
		tipo = tipo2;
		
	}
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
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
