package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class MostrarHabitacion implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		THabitacion habitacion = FactoriaNeg.getInstance().createSAHabitacion().mostrarHabitacion((int) requestContext.getData());
		
		if(habitacion != null)
			return new ResponseContext(Eventos.MOSTRAR_DATOS_HABITACION_OK, habitacion);
		else
			return new ResponseContext(Eventos.MOSTRAR_DATOS_HABITACION_KO, habitacion);

	}

}
