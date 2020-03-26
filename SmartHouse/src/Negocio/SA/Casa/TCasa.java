package Negocio.SA.Casa;

public class TCasa {

	private int ID;
	private String nombre;
	private Double temperatura;
	
	public TCasa () {
		ID=0;
		nombre = null;
		temperatura = 0.0;
	}
	
	public TCasa (int ID, String nombre, Double temperatura) {
		this.ID = ID;
		this.nombre = nombre;
		this.temperatura = temperatura;
	}
	
	public TCasa(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getTemperaturaDouble () {
		return temperatura;
	}
	
	public void setTemperatura (Double temperatura) {
		this.temperatura = temperatura;
	}
}
