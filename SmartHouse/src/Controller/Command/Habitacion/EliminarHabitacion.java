package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class EliminarHabitacion implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {

		
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHab = fact.createSAHabitacion();
		int respuesta = saHab.eliminarhab((int) requestContext.getData());
		
		if (respuesta != -1)
			return new ResponseContext(Eventos.ELIMINAR_HABITACION_OK, respuesta);
		else
			return new ResponseContext(Eventos.ELIMINAR_HABITACION_KO, respuesta);
	}
	

}
