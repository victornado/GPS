package Negocio.SA.Habitacion;

import java.util.ArrayList;

import Negocio.SA.Usuario.TUsuario;



public interface SAHabitacion {

	public abstract TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente);
	public abstract int modificarIluminacionHabitacion(TComponentesEnHabitacion componente); 
	public abstract String mostrarTipoHabitacion(THabitacion habitacion); 
	public abstract THabitacion  mostrarHabitacion(int id);
	public abstract int mostrarTemperaturaObjeto(int idHabitacion, int idObjeto);
	public abstract int mostrarHumedadObjeto(int idHabitacion, int idObjeto);
	public ArrayList<THabitacion> ListarHabitaciones();
	public THabitacion modificarHabitacion(THabitacion tHabitacion);
	public int mostrarIluminacionObjeto(int idHabitacion, int idObjeto);

}
