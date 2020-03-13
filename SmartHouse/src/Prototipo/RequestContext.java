package Prototipo;

public class RequestContext {
	
	
	private int idComando;
	private Object data;
	
	
	RequestContext (int id, Object datos){
		idComando= id;
		data=datos;
	}


	public int getCommandName() {	
		return idComando;
	}

}
