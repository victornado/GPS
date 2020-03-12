package Integraci�n;

import Integraci�n.Casa.DAOCasa;
import Integraci�n.Habitacion.DAOHabitacion;
import Integraci�n.Usuario.DAOUsuario;

public abstract class FactoryDAO {

	private static FactoryDAOImp instance;

	public static FactoryDAO getInstance() {
		if(instance == null) instance = new FactoryDAOImp();
		return instance;
	}
	public abstract DAOUsuario createDAOUsuario();
	public abstract DAOHabitacion createDAOHabitacion();
	public abstract DAOCasa createDAOCasa();
}