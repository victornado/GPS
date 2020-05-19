package Controller.Command.Habitacion;

import Controller.Command.Command;
import Controller.Command.Eventos;
import Negocio.Factoria.FactoriaNeg;
import Prototipo.Pair;
import Prototipo.RequestContext;
import Prototipo.ResponseContext;

public class MostrarTemperaturaObjeto implements Command{

	@Override
	public ResponseContext invoke(RequestContext requestContext) {
		Pair<Integer,Integer> datos=  (Pair<Integer, Integer>) requestContext.getData();
		int habitacion = FactoriaNeg.getInstance().createSAHabitacion().mostrarTemperaturaObjeto(datos.getFirst(),datos.getSecond());
		//TODO prototipo para devolver los 3 datos de respuesta
		Pair<Integer, Pair<Integer, Integer>> respuesta = new Pair<Integer,Pair<Integer,Integer>>(habitacion, datos);

		if(habitacion != -1)
			return new ResponseContext(Eventos.MOSTRAR_TEMPERATURA_OBJETO_OK, respuesta);

		else
			return new ResponseContext(Eventos.MOSTRAR_TEMPERATURA_OBJETO_KO, respuesta);
		
	}

}
