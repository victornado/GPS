package Negocio.SA.Habitacion;

public interface SAHabitacion {

	public abstract TComponentesEnHabitacion mostrarIluminacionHabitacion(TComponentesEnHabitacion componente);
	public abstract int modificarIluminacionHabitacion(TComponentesEnHabitacion componente); 
	public abstract String mostrarTipoHabitacion(THabitacion habitacion); 
	public abstract THabitacion  mostrarHabitacion(int id);
	public abstract int mostrarTemperaturaObjeto(int idHabitacion, int idObjeto);
	public abstract int mostrarHumedadObjeto(int idHabitacion, int idObjeto);
}
