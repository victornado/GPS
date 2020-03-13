package Controller;

import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public abstract class Controller {
	
	private static ControllerImp instance;
	
	public static Controller getInstance() {
		if(instance == null) instance = new ControllerImp();
		return instance;
	}
	
	public abstract ResponseContext handleRequest(RequestContext requestContext);
	public abstract void handleResponse(RequestContext requestContext,ResponseContext responseContext);
}
