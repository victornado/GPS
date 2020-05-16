package Controller.Command.Habitacion;

import java.util.ArrayList;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ListarHabitaciones implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHabitacion = fact.createSAHabitacion();
		ArrayList<THabitacion> respuesta = saHabitacion.ListarHabitaciones();
		
		if (respuesta != null)
			return new ResponseContext(Eventos.LISTAR_HABITACIONES_OK, respuesta);
		else
			return new ResponseContext(Eventos.LISTAR_HABITACIONES_KO, respuesta);
	}

}
