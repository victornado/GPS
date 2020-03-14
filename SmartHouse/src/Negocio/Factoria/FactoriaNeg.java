package Negocio.Factoria;

import Negocio.SA.Habitacion.SAHabitacion;
import Negocio.SA.Usuario.SAUsuario;

public abstract class FactoriaNeg {
	
	private static FactoriaNegImp instance;

	public static FactoriaNeg getInstance() {
		if(instance == null) instance = new FactoriaNegImp();
		return instance;
	}
	
	public abstract SAUsuario createSAUsuario();
	public abstract SAHabitacion createSAHabitacion();

}
