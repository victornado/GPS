package Integracion.Casa;

import Negocio.SA.Casa.TCasa;

public interface DAOCasa {	
	public abstract Double mostrarTemperatura(TCasa casa);

	public abstract Double mostrarHumedad(TCasa casa);

	public abstract Double mostrarIluminacion(TCasa casa);
}
