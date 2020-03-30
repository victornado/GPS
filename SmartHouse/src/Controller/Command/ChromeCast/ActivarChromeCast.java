package Controller.Command.ChromeCast;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ActivarChromeCast implements Command{

	@Override
	public ResponseContext invoke( RequestContext requestContext) {
		
		boolean correcto= FactoriaNeg.getInstance().createSAChromeCast().activarChromeCast();
		
		if(correcto)
			return new ResponseContext(Eventos.ACTIVAR_CHROMCAST_OK, null);

		else
			return new ResponseContext(Eventos.ACTIVAR_CHROMCAST_KO, null);
	}

}
