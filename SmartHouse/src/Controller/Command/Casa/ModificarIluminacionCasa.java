package Controller.Command.Casa;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Casa.TComponentesGenerales;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarIluminacionCasa implements Command{

	@Override
	public ResponseContext invoke( RequestContext requestContext) {
		
		int casa = FactoriaNeg.getInstance().createSACasa().modificarIluminacionCasa((TComponentesGenerales) requestContext.getData());
		
		if(casa != -1)
			return new ResponseContext(Eventos.MODIFICAR_ILUMINACION_OK, casa);
		else
			return new ResponseContext(Eventos.MODIFICAR_ILUMINACION_KO, casa);

	}

}
