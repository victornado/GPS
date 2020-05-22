package Integracion.Habitacion;

import java.util.ArrayList;
import java.util.List;

import Negocio.SA.Habitacion.TComponentesEnHabitacion;
import Negocio.SA.Habitacion.THabitacion;
import Negocio.SA.Usuario.TUsuario;

public interface DAOHabitacion {
	public abstract THabitacion mostrarHabitacion(int id);
	public THabitacion modificarHabitacion(THabitacion room);
	public abstract TComponentesEnHabitacion mostrarIluminacionHabitacion( TComponentesEnHabitacion componente);
	public abstract List<TComponentesEnHabitacion> getComponents(Integer idHabitacion);
	public abstract int modificarIluminacionHabitacion(TComponentesEnHabitacion componente);
	public abstract String mostrarTipoHabitacion(int id);
	public abstract ArrayList<THabitacion> ListarHabitaciones();
	public abstract ArrayList<THabitacion> ListarHabitacionesPorTipo(String tipo);


}
