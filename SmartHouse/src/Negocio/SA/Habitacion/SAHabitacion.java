package Negocio.SA.Habitacion;

public interface SAHabitacion {

	public abstract TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente);
	public abstract int modificarIluminacionHabitacion(TComponentesEnHabitacion componente); 
	public abstract String mostrarTipoHabitacion(THabitacion habitacion); 

}
