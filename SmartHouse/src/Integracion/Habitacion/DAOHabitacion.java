package Integracion.Habitacion;

import Negocio.SA.Habitacion.THabitacion;

public interface DAOHabitacion {
	public abstract THabitacion mostrarHabitacion(int id);
	public abstract THabitacion mostrarIluminacionHabitacion(THabitacion t);

}
