package Controller.Command.Habitacion;

import java.util.ArrayList;
import java.util.List;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ListarComponentesHabitacion implements Command {

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHabitacion = fact.createSAHabitacion();
		List<TComponentesEnHabitacion> respuesta = saHabitacion.ListarComponentesHabitaciones((int) requestContext.getData());
		
		if (respuesta != null)
			return new ResponseContext(Eventos.LISTAR_COMPONENTES_HABITACION_OK, respuesta);
		else
			return new ResponseContext(Eventos.LISTAR_COMPONENTES_HABITACION_KO, respuesta);
	}

}
