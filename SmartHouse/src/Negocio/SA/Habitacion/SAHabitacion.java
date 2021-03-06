package Negocio.SA.Habitacion;

import java.util.ArrayList;
import java.util.List;

import Negocio.SA.Usuario.TUsuario;



public interface SAHabitacion {

	public abstract TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente);
	public abstract int modificarIluminacionHabitacion(TComponentesEnHabitacion componente); 
	public abstract String mostrarTipoHabitacion(THabitacion habitacion); 
	public abstract THabitacion  mostrarHabitacion(int id);
	public abstract int mostrarTemperaturaObjeto(int idHabitacion, int idObjeto);
	public abstract int mostrarHumedadObjeto(int idHabitacion, int idObjeto);
	public ArrayList<THabitacion> ListarHabitaciones();
	public ArrayList<THabitacion> ListarHabitacionesPorTipo(String tipo);
	public List<TComponentesEnHabitacion> ListarComponentesHabitaciones(Integer idHabitacion);
	public THabitacion modificarHabitacion(THabitacion tHabitacion);
	public int mostrarIluminacionObjeto(int idHabitacion, int idObjeto);
	public int aniadirhab(THabitacion thab);
	public int eliminarhab(int i);
	public ArrayList<TComponentesEnHabitacion> ListarObjetos();
	public abstract int aniadirComponente(TComponentesEnHabitacion componente);
	public abstract int eliminarComponente(String nombre);
}
