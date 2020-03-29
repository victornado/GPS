package Negocio.SA.Casa;

public class TCasa {

	private int ID;
	private String nombre;
	private Double iluminacion;
	private Double temperatura;
	private Double humedad;
	
	public TCasa () {
		ID=0;
		nombre = null;
		iluminacion = 0.0;
		temperatura = 0.0;
		humedad = 0.0;
	}
	
	public TCasa (int ID, String nombre, Double iluminacion, Double temperatura, Double humedad) {
		this.ID = ID;
		this.nombre = nombre;
		this.iluminacion = iluminacion;
		this.temperatura = temperatura;
		this.humedad = humedad;
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

	public Double getIluminacionDouble() {
		return iluminacion;
	}

	public void setIluminacion(Double iluminacion) {
		this.iluminacion = iluminacion;
	}

	public Double getHumedadDouble() {
		return humedad;
	}

	public void setHumedad(Double humedad) {
		this.humedad = humedad;
	}
	
	
}
