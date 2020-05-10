package Controller.Command.Usuario;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Usuario.SAUsuario;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarUsuario implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAUsuario saUsuario = fact.createSAUsuario();
		TUsuario respuesta = saUsuario.modificarUsuario((TUsuario) requestContext.getData());
		
		if (respuesta != null)
			return new ResponseContext(Eventos.Modificar_USUARIO_OK, respuesta);
		else
			return new ResponseContext(Eventos.Modificar_USUARIO_KO, respuesta);
	}

}
