package Controller.Command.Casa;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Casa.SACasa;
import Negocio.SA.Casa.TComponentesGenerales;
import Negocio.SA.Usuario.TUsuario;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class MostrarDatosTemperatura implements Command {

	@Override
	public ResponseContext invoke( RequestContext requestContext) {
		
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SACasa saCasa = fact.createSACasa();
		Double respuesta = saCasa.MostrarDatosTemperatura((TComponentesGenerales) requestContext.getData());
		
		if (respuesta != null)
			return new ResponseContext(Eventos.MOSTRAR_TEMPERATURA_OK, respuesta);
		else
			return new ResponseContext(Eventos.MOSTRAR_TEMPERATURA_KO, respuesta);
	}
}
