package Controller.Command.Usuario;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Usuario.SAUsuario;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class EliminarUsuario implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAUsuario saUsuario = fact.createSAUsuario();
		int respuesta = saUsuario.eliminarUsuario((int) requestContext.getData());
		
		if (respuesta != -1)
			return new ResponseContext(Eventos.Eliminar_USUARIO_OK, respuesta);
		else
			return new ResponseContext(Eventos.Eliminar_USUARIO_KO, respuesta);
	}

}
