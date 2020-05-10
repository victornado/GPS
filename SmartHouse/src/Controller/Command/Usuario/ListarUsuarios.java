package Controller.Command.Usuario;

import java.util.ArrayList;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Usuario.SAUsuario;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ListarUsuarios implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAUsuario saUsuario = fact.createSAUsuario();
		ArrayList<TUsuario> respuesta = saUsuario.ListarUsuarios();
		
		if (respuesta != null)
			return new ResponseContext(Eventos.Listar_USUARIO_OK, respuesta);
		else
			return new ResponseContext(Eventos.Listar_USUARIO_KO, respuesta);
	}

}
