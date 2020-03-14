package Prototipo;

public class ResponseContext {
	
	private int idVista;
	private Object data;
	
	
	public ResponseContext (int id, Object datos){
		idVista= id;
		data=datos;
	}
	
	public int getVista() {
		return idVista;
	}
	
	public Object getData() {
		return data;
	}

}
