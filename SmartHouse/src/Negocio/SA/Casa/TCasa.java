package Negocio.SA.Casa;

import java.util.List;

public class TCasa {

	private int ID;
	private int IDCasa;
	private String tipo;
	private List<TComponentesGenerales> componentes;
	
	public TCasa(int id) {
		ID = id;
		
	}
	public TCasa() {
		// TODO Auto-generated constructor stub
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
