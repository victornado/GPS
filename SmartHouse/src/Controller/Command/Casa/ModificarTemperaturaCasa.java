package Controller.Command.Casa;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Casa.TComponentesGenerales;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarTemperaturaCasa implements Command{

	@Override
	public ResponseContext invoke( RequestContext requestContext) {
		
		int casa = FactoriaNeg.getInstance().createSACasa().modificarTemperaturaCasa((TComponentesGenerales) requestContext.getData());
		
		if(casa != -1)
			return new ResponseContext(Eventos.MODIFICAR_TEMPERATURA_OK, casa);
		else
			return new ResponseContext(Eventos.MODIFICAR_TEMPERATURA_KO, casa);

	}

}
