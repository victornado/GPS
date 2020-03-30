package Controller.Command;

import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public interface Command {

	public ResponseContext invoke(RequestContext requestContext);
		
}
