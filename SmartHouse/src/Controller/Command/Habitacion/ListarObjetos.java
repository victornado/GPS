package Controller.Command.Habitacion;

import java.util.ArrayList;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ListarObjetos implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		FactoriaNeg fact =  FactoriaNeg.getInstance();
		SAHabitacion saHabitacion = fact.createSAHabitacion();
		ArrayList<TComponentesEnHabitacion> respuesta = saHabitacion.ListarObjetos();
		
		if (respuesta != null) {
			return new ResponseContext(Eventos.LISTAR_OBJETOS_OK, respuesta);
		}
		else {
			return new ResponseContext(Eventos.LISTAR_OBJETOS_KO, respuesta);
		}
	}

}
