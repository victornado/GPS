package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class ModificarTemperaturaObjeto implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		
		int habitacion = FactoriaNeg.getInstance().createSAHabitacion().modificarIluminacionHabitacion((TComponentesEnHabitacion) requestContext.getData());
		
		if(habitacion != -1)
			return new ResponseContext(Eventos.MODIFICAR_TEMPERATURA_OBJETO_OK, habitacion);
		else
			return new ResponseContext(Eventos.MODIFICAR_TEMPERATURA_OBJETO_KO, habitacion);
	}

}
