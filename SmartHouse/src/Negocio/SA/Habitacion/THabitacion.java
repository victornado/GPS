package Negocio.SA.Habitacion;

public class THabitacion {

	private int ID;
	private int IDCasa;
	private String tipo;
	private int temperatura;
	private int iluminacion;
	
	public THabitacion(int id, int idCasa, String tipo2, int temperatura2, int int1) {
		ID = id;
		IDCasa = idCasa;
		tipo = tipo2;
		this.temperatura = temperatura2;
		this.iluminacion = int1;
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
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getIluminacion() {
		return iluminacion;
	}
	public void setIluminacion(int iluminacion) {
		this.iluminacion = iluminacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
