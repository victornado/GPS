package Prototipo;

public class RequestContext {
	
	
	private int idComando;
	private Object data;
	
	
	RequestContext (int id, Object datos){
		idComando= id;
		setData(datos);
	}


	public int getCommandName() {	
		return idComando;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

}
