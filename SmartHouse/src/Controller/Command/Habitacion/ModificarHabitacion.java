package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarHabitacion implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHabitacion = fact.createSAHabitacion();
		THabitacion respuesta = saHabitacion.modificarHabitacion((THabitacion) requestContext.getData());
		
		if (respuesta != null)
			return new ResponseContext(Eventos.MODIFICAR_HABITACION_OK, respuesta);
		else
			return new ResponseContext(Eventos.MODIFICAR_HABITACION_KO, respuesta);
	}

}
