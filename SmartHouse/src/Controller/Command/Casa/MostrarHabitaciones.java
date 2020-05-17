package Controller.Command.Casa;

import java.util.ArrayList;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Casa.SACasa;
import Negocio.SA.Casa.TComponentesGenerales;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class MostrarHabitaciones implements Command{
	
	@Override
	public ResponseContext invoke( RequestContext requestContext) {
		
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHab = fact.createSAHabitacion();
		ArrayList<THabitacion> respuesta = saHab.ListarHabitaciones();
		
		if (respuesta != null)
			return new ResponseContext(Eventos.MOSTRAR_HABITACIONES_OK, respuesta);
		else
			return new ResponseContext(Eventos.MOSTRAR_HABITACIONES_KO, respuesta);
	}

}
