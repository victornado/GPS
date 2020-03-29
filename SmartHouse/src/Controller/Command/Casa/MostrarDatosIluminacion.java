package Controller.Command.Casa;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Casa.SACasa;
import Negocio.SA.Casa.TCasa;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class MostrarDatosIluminacion implements Command {

	@Override
	public ResponseContext invoke(Command command, RequestContext requestContext) {
		
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SACasa saCasa = fact.createSACasa();
		Double respuesta = saCasa.MostrarDatosIluminacion((TCasa) requestContext.getData());
		
		if (respuesta != null)
			return new ResponseContext(Eventos.MOSTRAR_ILUMINACION_OK, respuesta);
		else
			return new ResponseContext(Eventos.MOSTRAR_ILUMINACION_KO, respuesta);
	}
}
