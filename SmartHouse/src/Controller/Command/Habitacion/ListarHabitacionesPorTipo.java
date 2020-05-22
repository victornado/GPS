package Controller.Command.Habitacion;

import java.util.ArrayList;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ListarHabitacionesPorTipo implements Command{
	
	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHabitacion = fact.createSAHabitacion();
		
		ArrayList<THabitacion> respuesta = saHabitacion.ListarHabitacionesPorTipo(requestContext.getData().toString());
		
		if (respuesta != null)
			return new ResponseContext(Eventos.LISTAR_HABITACIONES_POR_TIPO_OK, respuesta);
		else
			return new ResponseContext(Eventos.LISTAR_HABITACIONES_POR_TIPO_KO, respuesta);
	}
}
