package Integracion.Habitacion;

import java.util.List;

import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;

public interface DAOHabitacion {
	public abstract THabitacion mostrarHabitacion(int id);
	public abstract THabitacion mostrarIluminacionHabitacion(THabitacion t, TComponentesEnHabitacion componente);
	public abstract List<TComponentesEnHabitacion> getComponents(Integer idHabitacion);
	//public abstract THabitacion modificarIluminacionHabitacion(THabitacion habitacion, TComponenteEnHabitacion componente);

}
