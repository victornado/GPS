package Controller.Command.Usuario;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Usuario.SAUsuario;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class AniadirUsuario implements Command {

	@Override
	public ResponseContext invoke(Command command, RequestContext requestContext) {
		
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAUsuario saUsuario = fact.createSAUsuario();
		int respuesta = saUsuario.aniadirUsuario((TUsuario) requestContext.getData());
		
		if (respuesta != -1)
			return new ResponseContext(Eventos.Aniadir_USUARIO_OK, respuesta);
		else
			return new ResponseContext(Eventos.Aniadir_USUARIO_KO, respuesta);
	}

}
