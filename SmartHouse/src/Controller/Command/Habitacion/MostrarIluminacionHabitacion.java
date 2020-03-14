package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class MostrarIluminacionHabitacion implements Command{

	@Override
	public ResponseContext invoke(Command command, RequestContext requestContext) {
		
		
		THabitacion habitacion = FactoriaNeg.getInstance().createSAHabitacion().mostrarIluminacionHabitacion((THabitacion) requestContext.getData());
		
		if(habitacion != null)
			return new ResponseContext(Eventos.MOSTRAR_ILUMINACION_HABITACION_OK, habitacion);

		else
			return new ResponseContext(Eventos.MOSTRAR_ILUMINACION_HABITACION_KO, habitacion);
	}

}