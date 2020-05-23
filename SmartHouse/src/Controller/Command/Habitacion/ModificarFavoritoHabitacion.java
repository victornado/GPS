package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarFavoritoHabitacion implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {

		
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHab = fact.createSAHabitacion();
		THabitacion t = saHab.modificarHabitacion((THabitacion) requestContext.getData());
		
		if (t != null)
			return new ResponseContext(Eventos.MODIFICAR_FAVORITO_HABITACION_OK, t);
		else
			return new ResponseContext(Eventos.MODIFICAR_FAVORITO_HABITACION_KO, t);
	}
		
}
