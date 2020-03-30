package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarIluminacionHabitacion implements Command{

	@Override
	public ResponseContext invoke( RequestContext requestContext) {
		
		TComponentesEnHabitacion habitacion = FactoriaNeg.getInstance().createSAHabitacion().modificarIluminacionHabitacion((TComponentesEnHabitacion) requestContext.getData());
		
		if(habitacion != null)
			return new ResponseContext(Eventos.MODIFICAR_ILUMINACION_HABITACION_OK, habitacion);
		else
			return new ResponseContext(Eventos.MODIFICAR_ILUMINACION_HABITACION_KO, habitacion);

	}

}
