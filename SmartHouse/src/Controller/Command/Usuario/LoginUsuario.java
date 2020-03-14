package Controller.Command.Usuario;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class LoginUsuario implements Command {

	@Override
	public ResponseContext invoke(Command command, RequestContext requestContext) {
		
		//new ResponseContext(Eventos.LOGIN_USUARIO_KO, null)
		return new ResponseContext(Eventos.LOGIN_USUARIO_OK, null);
	}

}
