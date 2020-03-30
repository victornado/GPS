package Controller.Command.ChromeCast;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class SubirVolumen implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		
		boolean correcto= FactoriaNeg.getInstance().createSAChromeCast().modificarVolumenChromeCast((int) requestContext.getData());
		
		if(correcto)
			return new ResponseContext(Eventos.MODIFICA_VOLUMEN_CHROMCAST_OK, (int) requestContext.getData());

		else
			return new ResponseContext(Eventos.MODIFICA_VOLUMEN_CHROMCAST_KO, (int) requestContext.getData());
	}

}
