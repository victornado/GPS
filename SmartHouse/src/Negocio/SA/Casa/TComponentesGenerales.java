package Negocio.SA.Casa;

public class TComponentesGenerales{

	private int IDComponente;
	private String nombre;
	private int dato;
	private int IDcasa;
	private Double iluminacion = 0.0;
	private Double temperatura = 0.0;
	private Double humedad = 0.0;
	
	
	public TComponentesGenerales( int idComp, int casa, String nombre, int dato)
	{
		IDComponente = idComp;
		this.nombre = nombre;
		this.dato = dato;
		this.IDcasa = casa;
	}
	
	public TComponentesGenerales (int ID, String nombre, Double iluminacion, Double temperatura, Double humedad) {
		this.IDcasa = ID;
		this.nombre = nombre;
		this.iluminacion = iluminacion;
		this.temperatura = temperatura;
		this.humedad = humedad;
	}
	
	public TComponentesGenerales(int ID) {
		this.IDcasa = ID;
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
	
	public TComponentesGenerales() {
		// TODO Auto-generated constructor stub
	}

	public int getIDComponente() {
		return IDComponente;
	}
	public void setIDComponente(int iDComponente) {
		IDComponente = iDComponente;
	}
	public int getIDcasa() {
		return IDcasa;
	}
	public void setIDcasa(int iDhabitacion) {
		IDcasa = iDhabitacion;
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

